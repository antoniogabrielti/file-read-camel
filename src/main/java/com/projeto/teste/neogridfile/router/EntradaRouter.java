package com.projeto.teste.neogridfile.router;

import com.projeto.teste.neogridfile.configuration.FtpConfiguration;
import com.projeto.teste.neogridfile.processor.CadastroProcessor;
import com.projeto.teste.neogridfile.processor.EstoqueProcessor;
import com.projeto.teste.neogridfile.processor.VendaProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntradaRouter implements RoutesBuilder {
    private static Logger LOGGER = LoggerFactory.getLogger(EntradaRouter.class);

    private FtpConfiguration ftpConfiguration;
    private CadastroProcessor cadastroProcessor;
    private EstoqueProcessor estoqueProcessor;
    private VendaProcessor vendaProcessor;

    @Autowired
    public EntradaRouter(FtpConfiguration ftpConfiguration, CadastroProcessor cadastroProcessor, EstoqueProcessor estoqueProcessor, VendaProcessor vendaProcessor) {
        this.ftpConfiguration = ftpConfiguration;
        this.cadastroProcessor = cadastroProcessor;
        this.estoqueProcessor = estoqueProcessor;
        this.vendaProcessor = vendaProcessor;
    }

    @Override
    public void addRoutesToCamelContext(CamelContext context) throws Exception {
            context = new DefaultCamelContext();
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from(ftpConfiguration.getFtpEntrada())
                    .process(cadastroProcessor)
                    .process(estoqueProcessor)
                    .process(vendaProcessor);
                    //.to("direct:");
                }
            });

            context.start();

    }

}
