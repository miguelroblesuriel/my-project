
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

    private Lipid searchCerP(Spectrum spectrum, Map<String,Double> fas, Map<String,Double> SphPs){
        Iterator<String> itf= fas.keySet().iterator();
        Iterator<String> itSphP= SphPs.keySet().iterator();
        Lipid lipid1= new Lipid();
        lipid1.setType("CerP");
            while(itf.hasNext()){
                String fa= itf.next();
                for(int i=0; spectrum.getPeak(i)!=null;i++){
                    if(fas.get(fa)==spectrum.getPeak(i).getMz()){
                        if(lipid1.getChain2()==null){
                            lipid1.setChain2(fa,spectrum.getPeak(i).getIntensity());
                        }else if(lipid1.getChain3()==null){
                            lipid1.setChain3(fa,spectrum.getPeak(i).getIntensity());
                        }
                    }
                }
            }
            while(itSphP.hasNext()){
                String SphP= itSphP.next();
                for(int i=0; spectrum.getPeak(i)!=null;i++){
                    if(SphPs.get(SphP)==spectrum.getPeak(i).getMz()){
                        if(lipid1.getChain1()==null){
                            lipid1.setChain1(SphP,spectrum.getPeak(i).getIntensity());
                        }
                    }
                }
            }
            if(lipid1.getChain1()!=null && lipid1.getChain2()!=null && lipid1.getChain3()!=null){
                lipid1.setViability(true);
            }
            return lipid1;
    }
    private Lipid searchoPEpPE(Spectrum spectrum, Map<String,Double> fas, Map<String,Double> oLPEs, Map<String,Double> pLPEs){
        Lipid lipid1= new Lipid();
        lipid1.setType("oPE/pPE");
        lipid1.setHeadstatus(false);
        for(int i=0; spectrum.getPeak(i)!=null;i++){
            Iterator<String> itf= fas.keySet().iterator();
            Iterator<String> itoLPE= oLPEs.keySet().iterator();
            Iterator<String> itpLPE= pLPEs.keySet().iterator();
            while(itf.hasNext()){
                String fa= itf.next();
                if(fas.get(fa)==spectrum.getPeak(i).getMz()){
                    if(lipid1.getChain2()==null){
                        lipid1.setChain2(fa,spectrum.getPeak(i).getIntensity());
                    }else if(lipid1.getChain3()==null){
                        lipid1.setChain3(fa,spectrum.getPeak(i).getIntensity());
                    }
                }
            }
            while(itoLPE.hasNext()){
                String oLPE= itoLPE.next();
                if(oLPEs.get(oLPE)==spectrum.getPeak(i).getMz()){
                    if(lipid1.getChain1()==null){
                        lipid1.setChain1(oLPE,spectrum.getPeak(i).getIntensity());
                        lipid1.setType("oPE");
                    }
                }
            }
            while(itpLPE.hasNext()){
                String pLPE= itpLPE.next();
                if(pLPEs.get(pLPE)==spectrum.getPeak(i).getMz()){
                    if(lipid1.getChain1()==null){
                        lipid1.setChain1(pLPE,spectrum.getPeak(i).getIntensity());
                        lipid1.setType("pPE");
                    }
                }
            }
        }
        return lipid1;
    }
    private Lipid searchoPCpPC(Spectrum spectrum, Map<String,Double> fas, Map<String,Double> oLPCs, Map<String,Double> pLPCs){
        Lipid lipid1= new Lipid();
        lipid1.setType("oPC/pPC");
        lipid1.setHeadstatus(false);
        for(int i=0; spectrum.getPeak(i)!=null;i++){
            Iterator<String> itf= fas.keySet().iterator();
            Iterator<String> itoLPC= oLPCs.keySet().iterator();
            Iterator<String> itpLPC= pLPCs.keySet().iterator();
            while(itf.hasNext()){
                String fa= itf.next();
                if(fas.get(fa)==spectrum.getPeak(i).getMz()){
                    if(lipid1.getChain2()==null){
                        lipid1.setChain2(fa,spectrum.getPeak(i).getIntensity());
                    }else if(lipid1.getChain3()==null){
                        lipid1.setChain3(fa,spectrum.getPeak(i).getIntensity());
                    }
                }
            }
            while(itoLPC.hasNext()){
                String oLPC= itoLPC.next();
                if(oLPCs.get(oLPC)==spectrum.getPeak(i).getMz()){
                    if(lipid1.getChain1()==null){
                        lipid1.setChain1(oLPC,spectrum.getPeak(i).getIntensity());
                        lipid1.setType("oPC");
                    }
                }
            }
            while(itpLPC.hasNext()){
                String pLPC= itpLPC.next();
                if(pLPCs.get(pLPC)==spectrum.getPeak(i).getMz()){
                    if(lipid1.getChain1()==null){
                        lipid1.setChain1(pLPC,spectrum.getPeak(i).getIntensity());
                        lipid1.setType("pPC");
                    }
                }
            }
        }
        return lipid1;
    }
    private LinkedList<Lipid> searchHeads(Lipid lipid1, LinkedList<Lipid> lipids, Spectrum spectrum,Map<String,Double> heads){
        for(int i=0; spectrum.getPeak(i)!=null;i++){
            Iterator<String> ith= heads.keySet().iterator();
            while(ith.hasNext()){
                String head= ith.next();
                if(heads.get(head)==spectrum.getPeak(i).getMz()) {
                    lipid1.setHead(head);
                    lipids.add(new Lipid(lipid1));
                }
            }
        }
        return lipids;
    }

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
        heads.put("Head7",214.048);
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
        LinkedList<Lipid> lipids= new LinkedList<Lipid>();
        Lipid lipid= new Lipid();
        SpectrumUnit spectrumUnit= new SpectrumUnit();
        LipidUnit lipidUnit= new LipidUnit();
        Spectrum spectrum= new Spectrum(new Peak(50.1,10,0));
        spectrum.addPeak(new Peak(30.2,30,spectrum.getContador()));
        spectrum.addPeak(new Peak(30.4,30,spectrum.getContador()));
        spectrum.addPeak(new Peak(30.6,3,spectrum.getContador()));
        spectrum.addPeak(new Peak(1.007276,20,spectrum.getContador()));
        spectrum.addPeak(new Peak(168.0426,20,spectrum.getContador()));
        spectrum.addPeak(new Peak(-60.021129,20,spectrum.getContador()));
        spectrum.addPeak(new Peak(214.048,20,spectrum.getContador()));
        spectrum.addPeak(new Peak(60.1,200,spectrum.getContador()));
        RuleUnitInstance<LipidUnit> instance= RuleUnitProvider.get().createRuleUnitInstance(lipidUnit);
        for(int i=0; spectrum.getPeak(i)!=null;i++){
            if(spectrum.getPeak(i).getMz()==1.007276){
                lipids=searchHeads(searchCerP(spectrum,fas,SphPs),lipids,spectrum,heads);
                lipids=searchHeads(searchoPEpPE(spectrum,fas,oLPEs,pLPEs),lipids,spectrum,heads);
            }
            if(spectrum.getPeak(i).getMz()==-80.99525){
                lipids=searchHeads(searchoPEpPE(spectrum,fas,oLPEs,pLPEs),lipids,spectrum,heads);
            }
            if(spectrum.getPeak(i).getMz()==-60.021129){
                lipids=searchHeads(searchoPCpPC(spectrum,fas,oLPCs,pLPCs),lipids,spectrum,heads);
            }
            if(spectrum.getPeak(i).getMz()==-82.00307){
                lipids=searchHeads(searchoPCpPC(spectrum,fas,oLPCs,pLPCs),lipids,spectrum,heads);
            }

        }
        Iterator<Lipid> itLipid= lipids.iterator();
        while(itLipid.hasNext()){
            lipid=itLipid.next();
            try{
                lipidUnit.getLipid().add(lipid);
                instance.fire();
            }finally {
                instance.close();
            }
            System.out.println(lipid);
        }

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