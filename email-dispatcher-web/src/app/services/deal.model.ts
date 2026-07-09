export interface Contact {
  id: number;
  name: string;
  legalName: string;
  informationNote: string;
  email: string;
}

export interface Deal {
  id: number;
  title: string;
  contact: Contact;
  createDate: string;
}

export interface GetAllDealsResponse {
  value: Deal[];
}

export interface GetDealByIdResponse {
  value: Deal;
}

export interface DispatchEmailRequest {
  email: string;
  title: string;
  contactName: string;
  note: string;
  additionalInfo: string;
}
