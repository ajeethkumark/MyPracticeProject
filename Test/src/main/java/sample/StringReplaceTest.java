package sample;

public class StringReplaceTest {
	public static void main(String[] arg)
	{
		String data="rule \"CommercialAutoVehicleCollisionCoverageracaWantedCW4044RB-CA-TX-03012019-V01\"\n" + 
				"no-loop\n" + 
				"ruleflow-group \"Calculate_CA_CommercialAutoVehicleCollisionCoverage_racaWanted\"   ";
		
		data=data.replaceAll("03012019", "111101");
		System.out.println(data);
	}

}
