package br.com.eshopper.ecommerce.correiosws;

import java.math.BigDecimal;
import java.util.List;

import br.com.eshopper.ecommerce.soap.correios.CResultado;
import br.com.eshopper.ecommerce.soap.correios.CServico;
import br.com.eshopper.ecommerce.soap.correios.CalcPrecoPrazoWS;
import br.com.eshopper.ecommerce.soap.correios.CalcPrecoPrazoWSSoap;

public class ClientCorreios {
	
	public static List<CServico> calculate(String cepDestino) {
        CalcPrecoPrazoWSSoap client = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();

        String codigoSedex = "41106";
        String cepOrigem  = "04101300";
        String peso3kg = "1";
        BigDecimal comprimento20cm = new BigDecimal(20);
        BigDecimal altura10cm = new BigDecimal(10);
        BigDecimal largura15cm = new BigDecimal(15);
        BigDecimal diametro10cm = new BigDecimal(10);
        int formatoEncomendaCaixa = 1;
        BigDecimal semValorDeclarado= BigDecimal.ZERO;
        String semEntregueEmMaos = "N";
        String semAvisoRecebimento = "N";
        String semCodigoEmpresa = "";
        String semSenhaEmpresa = "";

        CResultado result = client.calcPrecoPrazo(
                        semCodigoEmpresa, semSenhaEmpresa, 
                        codigoSedex, cepOrigem, cepDestino, 
                        peso3kg, formatoEncomendaCaixa, 
                        comprimento20cm, altura10cm, largura15cm, diametro10cm, 
                        semEntregueEmMaos, semValorDeclarado, semAvisoRecebimento);

        return result.getServicos().getCServico();
    }
	
}
