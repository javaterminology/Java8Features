package com.raja.io.updates;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PurchaseDetailsTest {

	public static List<PurchaseDetails> getPurchase() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<PurchaseDetails> purchaseDetailList = new ArrayList<PurchaseDetails>();
		Reader reader = new FileReader("d://Rajasekhar//purchaseorders.txt");
		Map<String, Map> map = mapper.readValue(reader, Map.class);
		
		/*start*/
				    
				
		
						   
		
		/*end*/
		
		
		
		
		//Map<String, Map> payload = map.get("payload");
	     Map<String, Map> showPurchaseOrderMap = map.get("ShowPurchaseOrder");
		if (showPurchaseOrderMap.get("value") != null) {
			Map<String, Map> valueMap = showPurchaseOrderMap.get("value");
			List<Map<String, Map>> purchaseOrder = (List<Map<String, Map>>) valueMap.get("DataArea")
					.get("PurchaseOrder");
			if (purchaseOrder != null && !purchaseOrder.isEmpty()) {
				for (Map<String, Map> purchasemap : purchaseOrder) {
					String id = null;
					Map<String, Map> purchaseOrderHeader = purchasemap.get("PurchaseOrderHeader");
					if (purchaseOrderHeader.get("ID").get("value") != null)
						id = (String) purchaseOrderHeader.get("ID").get("value");

					String docRefId = null;
					List<Map<String, Map>> docRef = (List<Map<String, Map>>) purchaseOrderHeader
							.get("DocumentReference");
					if (docRef != null && !docRef.isEmpty()) {
						if (docRef.get(0).get("ID").get("value") != null)
							docRefId = (String) docRef.get(0).get("ID").get("value");
					}
					String statusVal = null;
					List<Map<String, Map>> status = (List<Map<String, Map>>) purchaseOrderHeader.get("Status");
					if (status != null && !status.isEmpty()) {
						if (status.get(0).get("Description").get("value") != null)
							statusVal = (String) status.get(0).get("Description").get("value");
					}
					String salesOrdRef = null;
					List<Map<String, Map>> salesOrderReference = (List<Map<String, Map>>) purchaseOrderHeader
							.get("SalesOrderReference");
					if (salesOrderReference != null && !salesOrderReference.isEmpty()) {
						if (salesOrderReference.get(0).get("ID").get("value") != null)
							salesOrdRef = (String) salesOrderReference.get(0).get("ID").get("value");
					}
					Set<String> shipmentDate = new HashSet<>();
					Set<String> shipmentFrom = new HashSet<>();
					List<Map<String, Object>> purchaseOrderLine = (List<Map<String, Object>>) purchasemap
							.get("PurchaseOrderLine");

					if (purchaseOrderLine != null && !purchaseOrderLine.isEmpty()) {
						for (Map<String, Object> map2 : purchaseOrderLine) {

							PurchaseDetails purchaseDetails = new PurchaseDetails();
							purchaseDetails.setPurchaseOrderId(id);
							purchaseDetails.setDocumentReference(docRefId);
							purchaseDetails.setStatus(statusVal);
							

							if (map2.get("SalesOrderReference") != null) {
								Map<String, Map> salesOrderRef = (Map<String, Map>) map2.get("SalesOrderReference");
								Map<String, Object> lineNumberID = salesOrderRef.get("LineNumberID");
								if (lineNumberID.get("value") != null) {
									StringBuilder ref = new StringBuilder();
									ref.append(salesOrdRef).append("_").append(lineNumberID.get("value"));
									purchaseDetails.setSalesOrderReference(ref.toString());
								}
							}
							if (map2.get("PromisedDeliveryDateTime") != null) {
								purchaseDetails.setPromishedDeliveryDate((String) map2.get("PromisedDeliveryDateTime"));
							}

							if (map2.get("ShipFromParty") != null) {

								List<Map<String, Map>> shipFrom = (List<Map<String, Map>>) map2.get("ShipFromParty");
								if (shipFrom != null && !shipFrom.isEmpty()) {
									for (Map<String, Map> map3 : shipFrom) {
										if (map3.get("Location") != null) {
											List<Map<String, Map>> location = (List<Map<String, Map>>) map3
													.get("Location");
											if (location != null && !location.isEmpty()) {
												for (Map<String, Map> map4 : location) {
													if (map4.get("Name") != null) {
														List<Map<String, Object>> name = (List<Map<String, Object>>) map4
																.get("Name");
														if (name != null && !name.isEmpty()) {
															for (Map<String, Object> map5 : name) {
																if (map5.get("value") != null) {
																	shipmentFrom.add((String) map5.get("value"));
																	purchaseDetails.setShipmentFrom(
																			(String) map5.get("value"));
																}
															}
														}
													}

												}
											}
										}
									}
								}

							}

							if (map2.get("Status") != null) {

								List<Map<String, Map>> statusDetail = (List<Map<String, Map>>) map2.get("Status");
								if (statusDetail != null && !statusDetail.isEmpty()) {
									for (Map<String, Map> map3 : statusDetail) {
										if (map3.get("Extension") != null) {
											List<Map<String, Map>> extension = (List<Map<String, Map>>) map3
													.get("Extension");
											if (extension != null && !extension.isEmpty()) {
												for (Map<String, Map> map4 : extension) {
													if (map4.get("DateTime") != null) {
														List<Map<String, Object>> dateTime = (List<Map<String, Object>>) map4
																.get("DateTime");
														if (dateTime != null && !dateTime.isEmpty()) {
															for (Map<String, Object> map5 : dateTime) {
																if (map5.get("value") != null) {
																	shipmentDate.add((String) map5.get("value"));
																	purchaseDetails.setShipmentDate(
																			(String) map5.get("value"));
																}
															}
														}
													}

												}
											}

										}
									}
								}

							}
							purchaseDetailList.add(purchaseDetails);

						}

					}

					System.out.println(purchaseDetailList);
					System.out.println(purchaseDetailList.size());

				}
			}

		}
		return purchaseDetailList;

	}
	public static void main(String[] args) throws IOException {
		getPurchase();
		
		
	}

}
