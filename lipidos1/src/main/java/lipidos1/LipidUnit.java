package lipidos1;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class LipidUnit implements RuleUnitData {
    private final DataStore<Lipid> lipid;


    public LipidUnit() {
        this(DataSource.createStore());
    }

    public LipidUnit(DataStore<Lipid> lipid) {
        this.lipid=lipid;
    }

    public DataStore<Lipid> getLipid() {
        return this.lipid;
    }

}