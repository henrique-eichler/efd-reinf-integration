package br.gov.receita.reinf.r4020.mapper;

import br.gov.receita.reinf.r4020.entity.*;
import br.gov.receita.reinf.r4020.schema.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Mapper
public interface R4020Mapper {

    R4020Mapper INSTANCE = Mappers.getMapper(R4020Mapper.class);

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
    @Mapping(source = "evtRetPJ.ideEvento.indRetif", target = "indRetif")
    @Mapping(source = "evtRetPJ.ideEvento.nrRecibo", target = "nrRecibo")
    @Mapping(source = "evtRetPJ.ideEvento.perApur", target = "perApur", qualifiedByName = "xmlGregorianCalendarToYearMonth")
    @Mapping(source = "evtRetPJ.ideEvento.tpAmb", target = "tpAmb")
    @Mapping(source = "evtRetPJ.ideEvento.procEmi", target = "procEmi")
    @Mapping(source = "evtRetPJ.ideEvento.verProc", target = "verProc")
    @Mapping(source = "evtRetPJ.id", target = "idEvento")
    @Mapping(source = "evtRetPJ.ideContri", target = "contribuinte")
    @Mapping(source = "evtRetPJ.ideEstab", target = "estabelecimento")
    @Mapping(target = "id", ignore = true)
    EventoRetencaoPessoaJuridica toEntity(Reinf reinfXml);

    // Mapear Contribuinte
    @Mapping(source = "tpInsc", target = "tpInsc")
    @Mapping(source = "nrInsc", target = "nrInsc")
    Contribuinte toContribuinte(Reinf.EvtRetPJ.IdeContri ideContri);

    // Mapear Estabelecimento
    @Mapping(source = "tpInscEstab", target = "tpInscEstab")
    @Mapping(source = "nrInscEstab", target = "nrInscEstab")
    @Mapping(source = "ideBenef", target = "beneficiario")
    @Mapping(target = "id", ignore = true)
    Estabelecimento toEstabelecimento(Reinf.EvtRetPJ.IdeEstab ideEstab);

    // Mapear Beneficiario
    @Mapping(source = "cnpjBenef", target = "cnpjBenef")
    @Mapping(source = "nmBenef", target = "nmBenef")
    @Mapping(source = "isenImun", target = "isenImun")
    @Mapping(source = "ideEvtAdic", target = "ideEvtAdic")
    @Mapping(source = "idePgto", target = "pagamentos")
    @Mapping(target = "id", ignore = true)
    Beneficiario toBeneficiario(Reinf.EvtRetPJ.IdeEstab.IdeBenef ideBenef);

    // Mapear Pagamento
    @Mapping(source = "natRend", target = "natRend")
    @Mapping(source = "observ", target = "observ")
    @Mapping(target = "dtFG", expression = "java(infoPgtoToDtFG(idePgto))")
    @Mapping(target = "vlrBruto", expression = "java(infoPgtoToVlrBruto(idePgto))")
    @Mapping(target = "indFciScp", expression = "java(infoPgtoToIndFciScp(idePgto))")
    @Mapping(target = "nrInscFciScp", expression = "java(infoPgtoToNrInscFciScp(idePgto))")
    @Mapping(target = "percSCP", expression = "java(infoPgtoToPercSCP(idePgto))")
    @Mapping(target = "indJud", expression = "java(infoPgtoToIndJud(idePgto))")
    @Mapping(target = "paisResidExt", expression = "java(infoPgtoToPaisResidExt(idePgto))")
    @Mapping(target = "dtEscrCont", expression = "java(infoPgtoToDtEscrCont(idePgto))")
    @Mapping(target = "observPgto", expression = "java(infoPgtoToObservPgto(idePgto))")
    @Mapping(target = "retencoes", expression = "java(infoPgtoToRetencoes(idePgto))")
    @Mapping(target = "id", ignore = true)
    Pagamento toPagamento(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto);

    // Helper methods for mapping InfoPgto fields
    default LocalDate infoPgtoToDtFG(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return this.xmlGregorianCalendarToLocalDate(idePgto.getInfoPgto().get(0).getDtFG());
    }

    default BigDecimal infoPgtoToVlrBruto(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getVlrBruto() == null) {
            return null;
        }
        return new BigDecimal(idePgto.getInfoPgto().get(0).getVlrBruto());
    }

    default Integer infoPgtoToIndFciScp(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getIndFciScp() == null) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getIndFciScp().intValue();
    }

    default String infoPgtoToNrInscFciScp(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getNrInscFciScp();
    }

    default BigDecimal infoPgtoToPercSCP(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getPercSCP() == null) {
            return null;
        }
        return new BigDecimal(idePgto.getInfoPgto().get(0).getPercSCP());
    }

    default String infoPgtoToIndJud(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getIndJud();
    }

    default String infoPgtoToPaisResidExt(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getPaisResidExt();
    }

    default LocalDate infoPgtoToDtEscrCont(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return this.xmlGregorianCalendarToLocalDate(idePgto.getInfoPgto().get(0).getDtEscrCont());
    }

    /**
     * Maps InfoPgto.observ field to Pagamento.observPgto field
     * This method maps the observation field from the InfoPgto level in the XML schema
     * to the observPgto field in the Pagamento entity.
     */
    default String infoPgtoToObservPgto(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getObserv();
    }

    default Retencoes infoPgtoToRetencoes(Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getRetencoes() == null) {
            return null;
        }

        Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto.InfoPgto.Retencoes xmlRetencoes = idePgto.getInfoPgto().get(0).getRetencoes();

        Retencoes retencoes = new Retencoes();
        if (xmlRetencoes.getVlrBaseIR() != null) {
            retencoes.setVlrBaseIR(new BigDecimal(xmlRetencoes.getVlrBaseIR()));
        }
        if (xmlRetencoes.getVlrIR() != null) {
            retencoes.setVlrIR(new BigDecimal(xmlRetencoes.getVlrIR()));
        }
        if (xmlRetencoes.getVlrBaseAgreg() != null) {
            retencoes.setVlrBaseAgreg(new BigDecimal(xmlRetencoes.getVlrBaseAgreg()));
        }
        if (xmlRetencoes.getVlrAgreg() != null) {
            retencoes.setVlrAgreg(new BigDecimal(xmlRetencoes.getVlrAgreg()));
        }
        if (xmlRetencoes.getVlrBaseCSLL() != null) {
            retencoes.setVlrBaseCSLL(new BigDecimal(xmlRetencoes.getVlrBaseCSLL()));
        }
        if (xmlRetencoes.getVlrCSLL() != null) {
            retencoes.setVlrCSLL(new BigDecimal(xmlRetencoes.getVlrCSLL()));
        }
        if (xmlRetencoes.getVlrBaseCofins() != null) {
            retencoes.setVlrBaseCofins(new BigDecimal(xmlRetencoes.getVlrBaseCofins()));
        }
        if (xmlRetencoes.getVlrCofins() != null) {
            retencoes.setVlrCofins(new BigDecimal(xmlRetencoes.getVlrCofins()));
        }
        if (xmlRetencoes.getVlrBasePP() != null) {
            retencoes.setVlrBasePP(new BigDecimal(xmlRetencoes.getVlrBasePP()));
        }
        if (xmlRetencoes.getVlrPP() != null) {
            retencoes.setVlrPP(new BigDecimal(xmlRetencoes.getVlrPP()));
        }

        return retencoes;
    }

    // List Mappings
    List<Pagamento> toPagamentoList(List<Reinf.EvtRetPJ.IdeEstab.IdeBenef.IdePgto> idePgtoList);
}
