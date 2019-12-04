package br.com.exemplo.eicon.cucumber.stepdefs;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import br.com.exemplo.eicon.EiconApp;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = EiconApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
