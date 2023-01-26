
package lipidos1;

import java.util.List;

import org.drools.ruleunits.api.RuleUnitProvider;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuleTest {

    static final Logger LOG = LoggerFactory.getLogger(RuleTest.class);

    @Test
    public void test() {
        LOG.info("Creating RuleUnit");
        Map<Integer,String> heads= new HashMap<Integer,String>();
        heads.put(1,"Head1");
        heads.put(2,"Head2");
        heads.put(3,"Head3");
        Map<Integer,String> fas= new HashMap<Integer,String>();
        fas.put(10,"Fa1");
        fas.put(20,"Fa2");
        fas.put(30,"Fa3");
        fas.put(40,"Fa4");
        fas.put(50,"Fa5");
        fas.put(60,"Fa6");
        Lipid lipid= new Lipid();
        SpectrumUnit spectrumUnit= new SpectrumUnit();
        Spectrum spectrum= new Spectrum(new Peak(50,300,0));
        spectrum.addPeak(new Peak(30,100,0));
        spectrum.addPeak(new Peak(2,20,0));
        spectrum.addPeak(new Peak(123,300,0));
        System.out.println(spectrum.getPeak(0).getIntensity()+ " "+ spectrum.getPeak(1).getIntensity());
        RuleUnitInstance<SpectrumUnit> instance= RuleUnitProvider.get().createRuleUnitInstance(spectrumUnit);
        try{
            spectrumUnit.getSpectrum().add(spectrum);

        }finally {
            instance.close();
        }

        for(int i=0; spectrum.getPeak(i)!=null;i++){
            if(heads.containsKey(spectrum.getPeak(i).getMz())){
                lipid.setHead(heads.get(spectrum.getPeak(i).getMz()));
            }
            if(fas.containsKey(spectrum.getPeak(i).getMz())){
                lipid.addFa(fas.get(spectrum.getPeak(i).getMz()));
            }
        }

        System.out.println(lipid);
        System.out.println(spectrum.getPeak(0).getPosition());
        /*MeasurementUnit measurementUnit = new MeasurementUnit();

        RuleUnitInstance<MeasurementUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(measurementUnit);
        try {
            LOG.info("Insert data");
            measurementUnit.getMeasurements().add(new Measurement("color", "red"));
            measurementUnit.getMeasurements().add(new Measurement("color", "green"));
            measurementUnit.getMeasurements().add(new Measurement("color", "blue"));

            LOG.info("Run query. Rules are also fired");
            List<Measurement> queryResult = instance.executeQuery("FindColor").toList("$m");

            assertEquals(3, queryResult.size());
            assertTrue("contains red", measurementUnit.getControlSet().contains("red"));
            assertTrue("contains green", measurementUnit.getControlSet().contains("green"));
            assertTrue("contains blue", measurementUnit.getControlSet().contains("blue"));
        } finally {
            instance.close();
        }*/
    }
}