package br.gov.receita.reinf.r4010.entity;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

class EventoRetencaoPessoaFisicaTest {

    @Test
    void testBuilderAndGettersSetters() {
        // Create a contribuinte for the evento
        Contribuinte contribuinte = Contribuinte.builder()
                .tpInsc(1) // 1 - CNPJ
                .nrInsc("12345678901234")
                .build();
        
        // Create a beneficiario for the estabelecimento
        Beneficiario beneficiario = Beneficiario.builder()
                .id(10L)
                .cpfBenef("12345678901")
                .nmBenef("John Doe")
                .build();
        
        // Create an estabelecimento for the evento
        Estabelecimento estabelecimento = Estabelecimento.builder()
                .id(20L)
                .tpInscEstab(1) // 1 - CNPJ
                .nrInscEstab("12345678901234")
                .beneficiario(beneficiario)
                .build();
        
        // Create an evento using the builder
        YearMonth perApur = YearMonth.of(2023, 1);
        EventoRetencaoPessoaFisica evento = EventoRetencaoPessoaFisica.builder()
                .id(1L)
                .idEvento("ID1234567890")
                .indRetif(1)
                .nrRecibo("1.2.3456789")
                .perApur(perApur)
                .tpAmb(1)
                .procEmi(1)
                .verProc("1.0")
                .contribuinte(contribuinte)
                .estabelecimento(estabelecimento)
                .build();

        // Verify getters
        assertEquals(1L, evento.getId());
        assertEquals("ID1234567890", evento.getIdEvento());
        assertEquals(1, evento.getIndRetif());
        assertEquals("1.2.3456789", evento.getNrRecibo());
        assertEquals(perApur, evento.getPerApur());
        assertEquals(1, evento.getTpAmb());
        assertEquals(1, evento.getProcEmi());
        assertEquals("1.0", evento.getVerProc());
        
        assertNotNull(evento.getContribuinte());
        assertEquals(1, evento.getContribuinte().getTpInsc());
        assertEquals("12345678901234", evento.getContribuinte().getNrInsc());
        
        assertNotNull(evento.getEstabelecimento());
        assertEquals(20L, evento.getEstabelecimento().getId());
        assertEquals(1, evento.getEstabelecimento().getTpInscEstab());
        assertEquals("12345678901234", evento.getEstabelecimento().getNrInscEstab());
        
        assertNotNull(evento.getEstabelecimento().getBeneficiario());
        assertEquals(10L, evento.getEstabelecimento().getBeneficiario().getId());
        assertEquals("12345678901", evento.getEstabelecimento().getBeneficiario().getCpfBenef());
        assertEquals("John Doe", evento.getEstabelecimento().getBeneficiario().getNmBenef());

        // Test setters
        Contribuinte newContribuinte = Contribuinte.builder()
                .tpInsc(2) // 2 - CPF
                .nrInsc("98765432109")
                .build();
        
        Beneficiario newBeneficiario = Beneficiario.builder()
                .id(30L)
                .cpfBenef("98765432109")
                .nmBenef("Jane Doe")
                .build();
        
        Estabelecimento newEstabelecimento = Estabelecimento.builder()
                .id(40L)
                .tpInscEstab(2) // 2 - CPF
                .nrInscEstab("98765432109")
                .beneficiario(newBeneficiario)
                .build();
        
        YearMonth newPerApur = YearMonth.of(2023, 2);
        evento.setId(2L);
        evento.setIdEvento("ID0987654321");
        evento.setIndRetif(2);
        evento.setNrRecibo("9.8.7654321");
        evento.setPerApur(newPerApur);
        evento.setTpAmb(2);
        evento.setProcEmi(2);
        evento.setVerProc("2.0");
        evento.setContribuinte(newContribuinte);
        evento.setEstabelecimento(newEstabelecimento);

        // Verify updated values
        assertEquals(2L, evento.getId());
        assertEquals("ID0987654321", evento.getIdEvento());
        assertEquals(2, evento.getIndRetif());
        assertEquals("9.8.7654321", evento.getNrRecibo());
        assertEquals(newPerApur, evento.getPerApur());
        assertEquals(2, evento.getTpAmb());
        assertEquals(2, evento.getProcEmi());
        assertEquals("2.0", evento.getVerProc());
        
        assertNotNull(evento.getContribuinte());
        assertEquals(2, evento.getContribuinte().getTpInsc());
        assertEquals("98765432109", evento.getContribuinte().getNrInsc());
        
        assertNotNull(evento.getEstabelecimento());
        assertEquals(40L, evento.getEstabelecimento().getId());
        assertEquals(2, evento.getEstabelecimento().getTpInscEstab());
        assertEquals("98765432109", evento.getEstabelecimento().getNrInscEstab());
        
        assertNotNull(evento.getEstabelecimento().getBeneficiario());
        assertEquals(30L, evento.getEstabelecimento().getBeneficiario().getId());
        assertEquals("98765432109", evento.getEstabelecimento().getBeneficiario().getCpfBenef());
        assertEquals("Jane Doe", evento.getEstabelecimento().getBeneficiario().getNmBenef());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two eventos with the same ID
        EventoRetencaoPessoaFisica evento1 = EventoRetencaoPessoaFisica.builder().id(1L).build();
        EventoRetencaoPessoaFisica evento2 = EventoRetencaoPessoaFisica.builder().id(1L).build();
        
        // Create an evento with a different ID
        EventoRetencaoPessoaFisica evento3 = EventoRetencaoPessoaFisica.builder().id(2L).build();

        // Test equals
        assertEquals(evento1, evento2);
        assertNotEquals(evento1, evento3);
        
        // Test hashCode
        assertEquals(evento1.hashCode(), evento2.hashCode());
        assertNotEquals(evento1.hashCode(), evento3.hashCode());
        
        // Test equals with null and different class
        assertNotEquals(evento1, null);
        assertNotEquals(evento1, "not an evento");
    }
}