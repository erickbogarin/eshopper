package br.com.eshopper.ecommerce.ws;

import java.math.BigDecimal;
import java.util.List;

import br.com.eshopper.ecommerce.soap.correios.CResultado;
import br.com.eshopper.ecommerce.soap.correios.CServico;
import br.com.eshopper.ecommerce.soap.correios.CalcPrecoPrazoWS;
import br.com.eshopper.ecommerce.soap.correios.CalcPrecoPrazoWSSoap;

public class CorreiosClientWS {
	
	public static List<CServico> calcPrecoPrazo(String cepDestino) {
        CalcPrecoPrazoWSSoap client = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();

        String codigoSedex = "41106";
        String cepOrigem  = "04101300";
        String peso3kg = "1";
        BigDecimal comprimento20cm = new BigDecimal(20);
        BigDecimal altura10cm = BigDecimal.TEN;
        BigDecimal largura15cm = new BigDecimal(15);
        BigDecimal diametro10cm = BigDecimal.TEN;
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
