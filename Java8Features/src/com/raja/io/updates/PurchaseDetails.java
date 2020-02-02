package com.raja.io.updates;

import java.text.SimpleDateFormat;

import lombok.Data;
import lombok.ToString;


public class PurchaseDetails {
	private String purchaseOrderId;
	private String salesOrderReference;
	private String documentReference;
	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getSalesOrderReference() {
		return salesOrderReference;
	}

	public void setSalesOrderReference(String salesOrderReference) {
		this.salesOrderReference = salesOrderReference;
	}

	public String getDocumentReference() {
		return documentReference;
	}

	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getPromishedDeliveryDate() {
		return promishedDeliveryDate;
	}

	public void setPromishedDeliveryDate(String promishedDeliveryDate) {
		this.promishedDeliveryDate = promishedDeliveryDate;
	}

	public String getShipmentFrom() {
		return shipmentFrom;
	}

	public void setShipmentFrom(String shipmentFrom) {
		this.shipmentFrom = shipmentFrom;
	}

	private String status;
	private String shipmentDate;
	private String promishedDeliveryDate;
	private String shipmentFrom;
	
	public PurchaseDetails(){	
	}

	
	

	/*
	 * public PurchaseEntity copyTo(PurchaseEntity entity) throws ParseException {
	 * entity.setPurchaseOrderId(this.purchaseOrderId);
	 * entity.setSalesOrderReference(this.salesOrderReference);
	 * entity.setDocumentReference(this.documentReference);
	 * entity.setStatus(this.status); if(this.shipmentDate!=null){
	 * entity.setShipmentDate(format.parse(this.shipmentDate)); }
	 * if(this.promishedDeliveryDate!=null){
	 * entity.setPromishedDeliveryDate(format.parse(this.promishedDeliveryDate)); }
	 * entity.setShipmentFrom(this.shipmentFrom); return entity; }
	 */

	

}