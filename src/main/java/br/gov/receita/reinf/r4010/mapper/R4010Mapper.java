package br.gov.receita.reinf.r4010.mapper;

import br.gov.receita.reinf.r4010.entity.*;
import br.gov.receita.reinf.r4010.schema.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Mapper
public interface R4010Mapper {

    R4010Mapper INSTANCE = Mappers.getMapper(R4010Mapper.class);

    /**
     * Converte XMLGregorianCalendar para YearMonth
     */
    default YearMonth map(XMLGregorianCalendar value) {
        if (value == null) {
            return null;
        }
        return YearMonth.of(value.getYear(), value.getMonth());
    }

    // Mapear elemento raiz
    @Mapping(source = "evtRetPF.ideEvento.indRetif", target = "indRetif")
    @Mapping(source = "evtRetPF.ideEvento.nrRecibo", target = "nrRecibo")
    @Mapping(source = "evtRetPF.ideEvento.perApur", target = "perApur")
    @Mapping(source = "evtRetPF.ideEvento.tpAmb", target = "tpAmb")
    @Mapping(source = "evtRetPF.ideEvento.procEmi", target = "procEmi")
    @Mapping(source = "evtRetPF.ideEvento.verProc", target = "verProc")
    @Mapping(source = "evtRetPF.id", target = "idEvento")
    @Mapping(source = "evtRetPF.ideContri", target = "contribuinte")
    @Mapping(source = "evtRetPF.ideEstab", target = "estabelecimento")
    @Mapping(target = "id", ignore = true)
    EventoRetencaoPessoaFisica toEntity(Reinf reinfXml);

    // Mapear Contribuinte
    @Mapping(source = "tpInsc", target = "tpInsc")
    @Mapping(source = "nrInsc", target = "nrInsc")
    Contribuinte toContribuinte(Reinf.EvtRetPF.IdeContri ideContri);

    // Mapear Estabelecimento
    @Mapping(source = "tpInscEstab", target = "tpInscEstab")
    @Mapping(source = "nrInscEstab", target = "nrInscEstab")
    @Mapping(source = "ideBenef", target = "beneficiario")
    @Mapping(target = "id", ignore = true)
    Estabelecimento toEstabelecimento(Reinf.EvtRetPF.IdeEstab ideEstab);

    // Mapear Beneficiario
    @Mapping(source = "cpfBenef", target = "cpfBenef")
    @Mapping(source = "nmBenef", target = "nmBenef")
    @Mapping(source = "ideDep", target = "dependentes")
    @Mapping(source = "idePgto", target = "pagamentos")
    @Mapping(target = "id", ignore = true)
    Beneficiario toBeneficiario(Reinf.EvtRetPF.IdeEstab.IdeBenef ideBenef);

    // Mapear Pagamento
    @Mapping(source = "natRend", target = "natRend")
    @Mapping(source = "observ", target = "observ")
    @Mapping(source = "infoPgto", target = "deducoes", qualifiedByName = "mapDeducoes")
    @Mapping(target = "dtFG", expression = "java(infoPgtoToDtFG(idePgto))")
    @Mapping(target = "compFP", expression = "java(infoPgtoToCompFP(idePgto))")
    @Mapping(target = "indDecTerc", expression = "java(infoPgtoToIndDecTerc(idePgto))")
    @Mapping(target = "vlrRendBruto", expression = "java(infoPgtoToVlrRendBruto(idePgto))")
    @Mapping(target = "vlrRendTrib", expression = "java(infoPgtoToVlrRendTrib(idePgto))")
    @Mapping(target = "vlrIR", expression = "java(infoPgtoToVlrIR(idePgto))")
    @Mapping(target = "indRRA", expression = "java(infoPgtoToIndRRA(idePgto))")
    @Mapping(target = "indFciScp", expression = "java(infoPgtoToIndFciScp(idePgto))")
    @Mapping(target = "nrInscFciScp", expression = "java(infoPgtoToNrInscFciScp(idePgto))")
    @Mapping(target = "percSCP", expression = "java(infoPgtoToPercSCP(idePgto))")
    @Mapping(target = "indJud", expression = "java(infoPgtoToIndJud(idePgto))")
    @Mapping(target = "paisResidExt", expression = "java(infoPgtoToPaisResidExt(idePgto))")
    @Mapping(target = "id", ignore = true)
    Pagamento toPagamento(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto);

    // Mapear InfoPgto para Pagamento
    @Mapping(source = "dtFG", target = "dtFG")
    @Mapping(source = "compFP", target = "compFP")
    @Mapping(source = "indDecTerc", target = "indDecTerc")
    @Mapping(source = "vlrRendBruto", target = "vlrRendBruto")
    @Mapping(source = "vlrRendTrib", target = "vlrRendTrib")
    @Mapping(source = "vlrIR", target = "vlrIR")
    @Mapping(source = "indRRA", target = "indRRA")
    @Mapping(source = "indFciScp", target = "indFciScp")
    @Mapping(source = "nrInscFciScp", target = "nrInscFciScp")
    @Mapping(source = "percSCP", target = "percSCP")
    @Mapping(source = "indJud", target = "indJud")
    @Mapping(source = "paisResidExt", target = "paisResidExt")
    @Mapping(source = "detDed", target = "deducoes")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "natRend", ignore = true)
    void updatePagamentoFromInfoPgto(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto infoPgto, @MappingTarget Pagamento pagamento);

    // Mapear Dependente
    @Mapping(source = "cpfDep", target = "cpfDep")
    @Mapping(source = "relDep", target = "relDep")
    @Mapping(source = "descrDep", target = "descrDep")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dtNascto", ignore = true)
    @Mapping(target = "nome", ignore = true)
    Dependente toDependente(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdeDep ideDep);

    // Mapear Deducao
    @Mapping(source = "indTpDeducao", target = "indTpDeducao")
    @Mapping(source = "vlrDeducao", target = "vlrDeducao")
    @Mapping(source = "nrInscPrevComp", target = "nrInscPrevComp")
    @Mapping(source = "vlrPatrocFunp", target = "vlrPatrocFunp")
    @Mapping(source = "benefPen", target = "beneficiariosPensao")
    @Mapping(target = "id", ignore = true)
    Deducao toDeducao(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed detDed);

    // Map BeneficiarioPensao
    @Mapping(source = "cpfDep", target = "cpfDep")
    @Mapping(source = "vlrDepen", target = "vlrDepen")
    @Mapping(target = "id", ignore = true)
    BeneficiarioPensao toBeneficiarioPensao(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed.BenefPen benefPen);

    // Helper method to map deducoes from InfoPgto
    @Named("mapDeducoes")
    default List<Deducao> mapDeducoes(List<Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto> infoPgtoList) {
        if (infoPgtoList == null || infoPgtoList.isEmpty()) {
            return null;
        }

        List<Deducao> deducoes = new java.util.ArrayList<>();
        for (Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto infoPgto : infoPgtoList) {
            if (infoPgto.getDetDed() != null) {
                for (Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed detDed : infoPgto.getDetDed()) {
                    deducoes.add(toDeducao(detDed));
                }
            }
        }
        return deducoes;
    }

    // Helper methods for mapping InfoPgto fields
    default LocalDate infoPgtoToDtFG(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return xmlGregorianCalendarToLocalDate(idePgto.getInfoPgto().get(0).getDtFG());
    }

    default String infoPgtoToCompFP(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getCompFP();
    }

    default String infoPgtoToIndDecTerc(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getIndDecTerc();
    }

    default BigDecimal infoPgtoToVlrRendBruto(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getVlrRendBruto() == null) {
            return null;
        }
        return new BigDecimal(idePgto.getInfoPgto().get(0).getVlrRendBruto());
    }

    default BigDecimal infoPgtoToVlrRendTrib(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getVlrRendTrib() == null) {
            return null;
        }
        return new BigDecimal(idePgto.getInfoPgto().get(0).getVlrRendTrib());
    }

    default BigDecimal infoPgtoToVlrIR(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getVlrIR() == null) {
            return null;
        }
        return new BigDecimal(idePgto.getInfoPgto().get(0).getVlrIR());
    }

    default String infoPgtoToIndRRA(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getIndRRA();
    }

    default Integer infoPgtoToIndFciScp(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getIndFciScp() == null) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getIndFciScp().intValue();
    }

    default String infoPgtoToNrInscFciScp(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getNrInscFciScp();
    }

    default BigDecimal infoPgtoToPercSCP(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty() || idePgto.getInfoPgto().get(0).getPercSCP() == null) {
            return null;
        }
        return new BigDecimal(idePgto.getInfoPgto().get(0).getPercSCP());
    }

    default String infoPgtoToIndJud(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getIndJud();
    }

    default String infoPgtoToPaisResidExt(Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto idePgto) {
        if (idePgto == null || idePgto.getInfoPgto() == null || idePgto.getInfoPgto().isEmpty()) {
            return null;
        }
        return idePgto.getInfoPgto().get(0).getPaisResidExt();
    }

    // Helper method to convert XMLGregorianCalendar to LocalDate
    default LocalDate xmlGregorianCalendarToLocalDate(XMLGregorianCalendar xcal) {
        if (xcal == null) {
            return null;
        }
        return LocalDate.of(xcal.getYear(), xcal.getMonth(), xcal.getDay());
    }

    // List Mappings
    List<Pagamento> toPagamentoList(List<Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto> idePgtoList);
    List<Dependente> toDependenteList(List<Reinf.EvtRetPF.IdeEstab.IdeBenef.IdeDep> ideDepList);
    List<Deducao> toDeducaoList(List<Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed> detDedList);
    List<BeneficiarioPensao> toBeneficiarioPensaoList(List<Reinf.EvtRetPF.IdeEstab.IdeBenef.IdePgto.InfoPgto.DetDed.BenefPen> benefPenList);
}
