package br.gov.receita.reinf.r4040.mapper;

import br.gov.receita.reinf.r4040.entity.*;
import br.gov.receita.reinf.r4040.schema.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Mapper
public interface R4040Mapper {

    R4040Mapper INSTANCE = Mappers.getMapper(R4040Mapper.class);

    /**
     * Converte XMLGregorianCalendar para YearMonth
     */
    @Named("xmlGregorianCalendarToYearMonth")
    default YearMonth xmlGregorianCalendarToYearMonth(XMLGregorianCalendar value) {
        if (value == null) {
            return null;
        }
        return YearMonth.of(value.getYear(), value.getMonth());
    }

    /**
     * Converte XMLGregorianCalendar para LocalDate
     */
    @Named("xmlGregorianCalendarToLocalDate")
    default LocalDate xmlGregorianCalendarToLocalDate(XMLGregorianCalendar xcal) {
        if (xcal == null) {
            return null;
        }
        return LocalDate.of(xcal.getYear(), xcal.getMonth(), xcal.getDay());
    }

    // Mapear elemento raiz
    @Mapping(source = "evtBenefNId.ideEvento.indRetif", target = "indRetif")
    @Mapping(source = "evtBenefNId.ideEvento.nrRecibo", target = "nrRecibo")
    @Mapping(source = "evtBenefNId.ideEvento.perApur", target = "perApur", qualifiedByName = "xmlGregorianCalendarToYearMonth")
    @Mapping(source = "evtBenefNId.ideEvento.tpAmb", target = "tpAmb")
    @Mapping(source = "evtBenefNId.ideEvento.procEmi", target = "procEmi")
    @Mapping(source = "evtBenefNId.ideEvento.verProc", target = "verProc")
    @Mapping(source = "evtBenefNId.id", target = "idEvento")
    @Mapping(source = "evtBenefNId.ideContri", target = "contribuinte")
    @Mapping(source = "evtBenefNId.ideEstab", target = "estabelecimento")
    @Mapping(target = "id", ignore = true)
    EventoRetencaoBeneficiarioNaoIdentificado toEntity(Reinf reinfXml);

    // Mapear Contribuinte
    @Mapping(source = "tpInsc", target = "tpInsc")
    @Mapping(source = "nrInsc", target = "nrInsc")
    Contribuinte toContribuinte(Reinf.EvtBenefNId.IdeContri ideContri);

    // Mapear Estabelecimento
    @Mapping(source = "tpInscEstab", target = "tpInscEstab")
    @Mapping(source = "nrInscEstab", target = "nrInscEstab")
    @Mapping(source = "ideEvtAdic", target = "ideEvtAdic")
    @Mapping(source = "ideNat", target = "naturezasRendimento")
    @Mapping(target = "id", ignore = true)
    Estabelecimento toEstabelecimento(Reinf.EvtBenefNId.IdeEstab ideEstab);

    // Mapear NaturezaRendimento
    @Mapping(source = "natRend", target = "natRend")
    @Mapping(source = "infoPgto", target = "pagamentos")
    @Mapping(target = "id", ignore = true)
    NaturezaRendimento toNaturezaRendimento(Reinf.EvtBenefNId.IdeEstab.IdeNat ideNat);

    // Mapear Pagamento
    @Mapping(source = "dtFG", target = "dtFG", qualifiedByName = "xmlGregorianCalendarToLocalDate")
    @Mapping(source = "vlrLiq", target = "vlrLiq", qualifiedByName = "stringToBigDecimal")
    @Mapping(source = "vlrBaseIR", target = "vlrBaseIR", qualifiedByName = "stringToBigDecimal")
    @Mapping(source = "vlrIR", target = "vlrIR", qualifiedByName = "stringToBigDecimal")
    @Mapping(source = "dtEscrCont", target = "dtEscrCont", qualifiedByName = "xmlGregorianCalendarToLocalDate")
    @Mapping(source = "descr", target = "descr")
    @Mapping(source = "infoProcRet", target = "processosRetencao")
    @Mapping(target = "id", ignore = true)
    Pagamento toPagamento(Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto infoPgto);

    // Mapear ProcessoRetencao
    @Mapping(source = "tpProcRet", target = "tpProcRet")
    @Mapping(source = "nrProcRet", target = "nrProcRet")
    @Mapping(source = "codSusp", target = "codSusp")
    @Mapping(source = "vlrBaseSuspIR", target = "vlrBaseSuspIR", qualifiedByName = "stringToBigDecimal")
    @Mapping(source = "vlrNIR", target = "vlrNIR", qualifiedByName = "stringToBigDecimal")
    @Mapping(source = "vlrDepIR", target = "vlrDepIR", qualifiedByName = "stringToBigDecimal")
    @Mapping(target = "id", ignore = true)
    ProcessoRetencao toProcessoRetencao(Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto.InfoProcRet infoProcRet);

    // Helper method to convert String to BigDecimal
    @Named("stringToBigDecimal")
    default BigDecimal stringToBigDecimal(String value) {
        if (value == null) {
            return null;
        }
        return new BigDecimal(value.replace(",", "."));
    }

    // List Mappings
    List<NaturezaRendimento> toNaturezaRendimentoList(List<Reinf.EvtBenefNId.IdeEstab.IdeNat> ideNatList);
    List<Pagamento> toPagamentoList(List<Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto> infoPgtoList);
    List<ProcessoRetencao> toProcessoRetencaoList(List<Reinf.EvtBenefNId.IdeEstab.IdeNat.InfoPgto.InfoProcRet> infoProcRetList);
}