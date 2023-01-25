package lipidos1;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class SpectrumUnit implements RuleUnitData {
    private final DataStore<Spectrum> spectrum;


    public SpectrumUnit() {
        this(DataSource.createStore());
    }

    public SpectrumUnit(DataStore<Spectrum> spectrums) {
        this.spectrum=spectrums;
    }

    public DataStore<Spectrum> getSpectrum() {
        return this.spectrum;
    }

}
