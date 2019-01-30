package com.projeto.teste.neogridfile.router;

import com.projeto.teste.neogridfile.configuration.FtpConfiguration;
import com.projeto.teste.neogridfile.processor.CadastroProcessor;
import com.projeto.teste.neogridfile.processor.EstoqueProcessor;
import com.projeto.teste.neogridfile.processor.VendaProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.apache.camel.processor.SetHeaderProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntradaRouter extends RouteBuilder {
    private static Logger LOGGER = LoggerFactory.getLogger(EntradaRouter.class);

    private FtpConfiguration ftpConfiguration;
    private CadastroProcessor cadastroProcessor;
    private EstoqueProcessor estoqueProcessor;
    private VendaProcessor vendaProcessor;

    @Autowired
    public EntradaRouter(FtpConfiguration ftpConfiguration,
                         CadastroProcessor cadastroProcessor,
                         EstoqueProcessor estoqueProcessor,
                         VendaProcessor vendaProcessor) {
        this.ftpConfiguration = ftpConfiguration;
        this.cadastroProcessor = cadastroProcessor;
        this.estoqueProcessor = estoqueProcessor;
        this.vendaProcessor = vendaProcessor;
    }

    @Override
    public void configure() throws Exception {

        from(ftpConfiguration.getFtpEntrada()).startupOrder(1).to("direct:cadastro").end();

        from("direct:cadastro").validate(cadastroProcessor).startupOrder(2).to("direct:estoque").end();

        from("direct:estoque").validate(estoqueProcessor).startupOrder(3).to("direct:venda").end();

        from("direct:venda").validate(vendaProcessor).end();
    }
}
