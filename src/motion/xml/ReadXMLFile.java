/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package motion.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public Motion readMotion(String name) {

		Motion mot=new Motion();

		try {

			String[] NaoJoints = {"rae1",
					"rae2",
					"rae3",
					"rae4",
					"lae1",
					"lae2",
					"lae3",
					"lae4",
					"lle1",
					"lle2",
					"lle3",
					"lle4",
					"lle5",
					"lle6",
					"rle1",
					"rle2",
					"rle3",
					"rle4",
					"rle5",
			"rle6"};



			File fXmlFile = new File("motions/XMLMotions/"+name+".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList MotionList = doc.getElementsByTagName("low_skill");
			Node nNode2 = MotionList.item(0);
			if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode2;
				mot.setName(eElement.getAttribute("name"));
				mot.setFirstPhase(eElement.getAttribute("firstPhase"));

			}

			NodeList phaseList = doc.getElementsByTagName("phase");
			for (int temp = 0; temp < phaseList.getLength(); temp++) {

				Phase pha=new Phase();
				Node nNode = phaseList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					pha.setName(eElement.getAttribute("name"));
					pha.setNextPhase(eElement.getAttribute("next"));
					if(eElement.getAttribute("isFinal")==null){
						pha.setFinal(false);
					}else{
						if(eElement.getAttribute("isFinal").equalsIgnoreCase("true")){
							pha.setFinal(true);
						}else{
							pha.setFinal(false);
						}
					}

					for(int i=0;i<20;i++){
						NodeList Joints = eElement.getElementsByTagName(NaoJoints[i]);
						for (int temp1 = 0; temp1 < Joints.getLength(); temp1++) {
							Move mov=new Move();
							Node nNode1 = Joints.item(temp1);
							if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement1 = (Element) nNode1;
								mov.setAxis_name(NaoJoints[i]);
								mov.setValue(Float.parseFloat(eElement1.getAttribute("end")));
								pha.movements.addElement(mov);
								
							}
						}
					}


					NodeList Joints = eElement.getElementsByTagName("duration");
					Node nNode1 = Joints.item(0);
					if (nNode1.getNodeType() == Node.ELEMENT_NODE){
						Element eElement1 = (Element) nNode1;
						pha.setDuration(Integer.parseInt(eElement1.getTextContent()));
					}

					NodeList Finalize = eElement.getElementsByTagName("finalize");
					if(Finalize.getLength()!=0){
						Node nNode3 = Finalize.item(0);
						if (nNode3.getNodeType() == Node.ELEMENT_NODE){
							Element eElement1 = (Element) nNode3;
							if(eElement1.getTextContent().equalsIgnoreCase("")){
								pha.setFinalize("");
							}else{
								pha.setFinalize(eElement1.getTextContent());
							}
						}
					}

				}
				mot.phases.addElement(pha);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mot;
	}

	@SuppressWarnings("unused")
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

}