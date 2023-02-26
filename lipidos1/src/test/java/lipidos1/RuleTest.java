
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
        Map<String,Double> heads= new HashMap<String,Double>();
        heads.put("Head1",78.9585);
        heads.put("Head2",96.9685);
        heads.put("Head3",168.0426);
        heads.put("Head4",224.0688);
        heads.put("Head5",140.0115);
        heads.put("Head6",196.038);
        Map<String,Double> fas= new HashMap<String,Double>();
        fas.put("Fa1",10.1);
        fas.put("Fa2",20.1);
        fas.put("Fa3",30.1);
        fas.put("Fa4",40.1);
        fas.put("Fa5",50.1);
        fas.put("Fa6",60.1);
        Map<String,Double> SphPs= new HashMap<String,Double>();
        SphPs.put("SphP1",10.2);
        SphPs.put("SphP2",20.2);
        SphPs.put("SphP3",30.2);
        Map<String,Double> oLPCs= new HashMap<String,Double>();
        oLPCs.put("oLPC1",10.3);
        oLPCs.put("oLPC2",20.3);
        oLPCs.put("oLPC3",30.3);
        Map<String,Double> pLPCs= new HashMap<String,Double>();
        pLPCs.put("pLPC1",10.4);
        pLPCs.put("pLPC2",20.4);
        pLPCs.put("pLPC3",30.4);
        Map<String,Double> oLPEs= new HashMap<String,Double>();
        oLPEs.put("oLPE1",10.5);
        oLPEs.put("oLPE2",20.5);
        oLPEs.put("oLPE3",30.5);
        Map<String,Double> pLPEs= new HashMap<String,Double>();
        pLPEs.put("pLPE1",10.6);
        pLPEs.put("pLPE2",20.6);
        pLPEs.put("pLPE3",30.6);
        Lipid lipid= new Lipid();
        SpectrumUnit spectrumUnit= new SpectrumUnit();
        LipidUnit lipidUnit= new LipidUnit();
        Spectrum spectrum= new Spectrum(new Peak(50.1,10,0));
        spectrum.addPeak(new Peak(30.2,3,spectrum.getContador()));
        spectrum.addPeak(new Peak(78.9585,20,spectrum.getContador()));
        spectrum.addPeak(new Peak(60.1,200,spectrum.getContador()));
        RuleUnitInstance<LipidUnit> instance= RuleUnitProvider.get().createRuleUnitInstance(lipidUnit);
        for(int i=0; spectrum.getPeak(i)!=null;i++){
            Iterator<String> ith= heads.keySet().iterator();
            while(ith.hasNext()){
                String head= ith.next();
                if(heads.get(head)==spectrum.getPeak(i).getMz()){
                    lipid.setHead(head);
                    for(int j=0;spectrum.getPeak(j)!=null;j++){
                        Iterator<String> itSphP= SphPs.keySet().iterator();
                        Iterator<String> itf= fas.keySet().iterator();
                        Iterator<String> itoLPC= oLPCs.keySet().iterator();
                        Iterator<String> itpLPC= pLPCs.keySet().iterator();
                        Iterator<String> itoLPE= oLPEs.keySet().iterator();
                        Iterator<String> itpLPE= pLPEs.keySet().iterator();
                        if(spectrum.getPeak(i).getMz()==78.9585 || spectrum.getPeak(i).getMz()==96.9691){
                            lipid.setType("CerP");
                            while(itf.hasNext()){
                                String fa= itf.next();
                                if(fas.get(fa)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain2()==null){
                                        lipid.setChain2(fa,spectrum.getPeak(j).getIntensity());
                                    }
                                }
                            }
                            while(itSphP.hasNext()){
                                String SphP= itSphP.next();
                                if(SphPs.get(SphP)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain1()==null){
                                        lipid.setChain1(SphP,spectrum.getPeak(j).getIntensity());
                                    }
                                }
                            }
                            if(lipid.getChain1()!=null && lipid.getChain2()!=null){
                                lipid.setViability(true);
                            }
                        }
                        if(spectrum.getPeak(i).getMz()==168.0426 || spectrum.getPeak(i).getMz()==224.0688){
                            while(itf.hasNext()){
                                String fa= itf.next();
                                if(fas.get(fa)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain2()==null){
                                        lipid.setChain2(fa,spectrum.getPeak(j).getIntensity());
                                    }
                                }
                            }
                            while(itoLPC.hasNext()){
                                String oLPC= itoLPC.next();
                                if(oLPCs.get(oLPC)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain1()==null){
                                        lipid.setChain1(oLPC,spectrum.getPeak(j).getIntensity());
                                        lipid.setType("oPC");
                                    }
                                }
                            }
                            while(itpLPC.hasNext()){
                                String pLPC= itpLPC.next();
                                if(pLPCs.get(pLPC)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain1()==null){
                                        lipid.setChain1(pLPC,spectrum.getPeak(j).getIntensity());
                                        lipid.setType("pPC");
                                    }
                                }
                            }
                        }
                        if(spectrum.getPeak(i).getMz()==140.0115 || spectrum.getPeak(i).getMz()==196.038){
                            while(itf.hasNext()){
                                String fa= itf.next();
                                if(fas.get(fa)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain2()==null){
                                        lipid.setChain2(fa,spectrum.getPeak(j).getIntensity());
                                    }
                                }
                            }
                            while(itoLPE.hasNext()){
                                String oLPE= itoLPE.next();
                                if(oLPEs.get(oLPE)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain1()==null){
                                        lipid.setChain1(oLPE,spectrum.getPeak(j).getIntensity());
                                        lipid.setType("oPE");
                                    }
                                }
                            }
                            while(itpLPE.hasNext()){
                                String pLPE= itpLPE.next();
                                if(pLPEs.get(pLPE)==spectrum.getPeak(j).getMz()){
                                    if(lipid.getChain1()==null){
                                        lipid.setChain1(pLPE,spectrum.getPeak(j).getIntensity());
                                        lipid.setType("pPE");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Iterator<String> itf= fas.keySet().iterator();
            while(itf.hasNext()){
                String fa= itf.next();
                if(fas.get(fa)==spectrum.getPeak(i).getMz()){
                    lipid.setChain3(fa,spectrum.getPeak(i).getIntensity());
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