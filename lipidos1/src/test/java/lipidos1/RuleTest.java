
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
        Map<String,Integer> heads= new HashMap<String,Integer>();
        heads.put("Head1",1);
        heads.put("Head2",2);
        heads.put("Head3",3);
        Map<String,Integer> fas= new HashMap<String,Integer>();
        fas.put("Fa1",10);
        fas.put("Fa2",20);
        fas.put("Fa3",30);
        fas.put("Fa4",40);
        fas.put("Fa5",50);
        fas.put("Fa6",60);
        Lipid lipid= new Lipid();
        SpectrumUnit spectrumUnit= new SpectrumUnit();
        LipidUnit lipidUnit= new LipidUnit();
        Spectrum spectrum= new Spectrum(new Peak(50,3,0));
        spectrum.addPeak(new Peak(30,100,spectrum.getContador()));
        spectrum.addPeak(new Peak(2,20,spectrum.getContador()));
        spectrum.addPeak(new Peak(60,200,spectrum.getContador()));
        RuleUnitInstance<LipidUnit> instance= RuleUnitProvider.get().createRuleUnitInstance(lipidUnit);
        for(int i=0; spectrum.getPeak(i)!=null;i++){
            Iterator<String> ith= heads.keySet().iterator();
            Iterator<String> itf= fas.keySet().iterator();
            while(ith.hasNext()){
                String head= ith.next();
                if(heads.get(head)==spectrum.getPeak(i).getMz()){
                    lipid.setHead(head);
                }
            }
            while(itf.hasNext()){
                String fa= itf.next();
                if(fas.get(fa)==spectrum.getPeak(i).getMz()){
                    if(lipid.getFa1()==null){
                        lipid.setFa1(fa,spectrum.getPeak(i).getIntensity());
                    }else{
                        if(lipid.getFa2()==null){
                            lipid.setFa2(fa,spectrum.getPeak(i).getIntensity());
                        }else{
                            if(lipid.getFa3()==null){
                                lipid.setFa3(fa,spectrum.getPeak(i).getIntensity());
                            }
                        }
                    }
                }
            }
        }
        System.out.println(lipid);
        try{
            lipidUnit.getLipid().add(lipid);
           instance.fire();
        }finally {
            instance.close();
        }
        System.out.println(lipid);

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