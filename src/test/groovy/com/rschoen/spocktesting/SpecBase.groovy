package com.rschoen.spocktesting

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles("integration")
class SpecBase extends Specification{

    @Autowired
    Flyway flyway

    // runs before each feature method
    def setup() {
        flyway.migrate()
    }

    // runs after every feature method
    def cleanup() {
        def ds = flyway.getDataSource()
        def cn = ds.getConnection()
        def st = cn.createStatement()
        st.execute("DROP ALL OBJECT")

        cn.close()
    }


    // runs once, before first feature method
    def setupSpec() {

    }

    // runs once, after last feature method
    def cleanupSpec() {

    }
}
