package com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetContactResponse(
        @JsonProperty("@odata.context") String odataContext,
        List<ContactData> value
) {
    public record ContactData(
            @JsonProperty("Id") Integer id,
            @JsonProperty("AccountId") Integer accountId,
            @JsonProperty("TypeId") Integer typeId,
            @JsonProperty("Name") String name,
            @JsonProperty("LegalName") String legalName,
            @JsonProperty("Register") String register,
            @JsonProperty("CNPJ") String cnpj,
            @JsonProperty("CPF") String cpf,
            @JsonProperty("StatusId") Integer statusId,
            @JsonProperty("CompanyId") Integer companyId,
            @JsonProperty("RelationshipId") Integer relationshipId,
            @JsonProperty("LineOfBusinessId") Integer lineOfBusinessId,
            @JsonProperty("OriginId") Integer originId,
            @JsonProperty("NumberOfEmployeesId") Integer numberOfEmployeesId,
            @JsonProperty("ClassId") Integer classId,
            @JsonProperty("OwnerId") Integer ownerId,
            @JsonProperty("Birthday") String birthday,
            @JsonProperty("Note") String note,
            @JsonProperty("Email") String email,
            @JsonProperty("Website") String website,
            @JsonProperty("RoleId") Integer roleId,
            @JsonProperty("DepartmentId") Integer departmentId,
            @JsonProperty("Skype") String skype,
            @JsonProperty("Facebook") String facebook,
            @JsonProperty("StreetAddress") String streetAddress,
            @JsonProperty("StreetAddressNumber") String streetAddressNumber,
            @JsonProperty("StreetAddressLine2") String streetAddressLine2,
            @JsonProperty("Neighborhood") String neighborhood,
            @JsonProperty("ZipCode") String zipCode,
            @JsonProperty("CityId") Integer cityId,
            @JsonProperty("StateId") Integer stateId,
            @JsonProperty("CountryId") Integer countryId,
            @JsonProperty("CurrencyId") Integer currencyId,
            @JsonProperty("Latitude") Double latitude,
            @JsonProperty("Longitude") Double longitude,
            @JsonProperty("LastDealId") Integer lastDealId,
            @JsonProperty("Editable") Boolean editable,
            @JsonProperty("Deletable") Boolean deletable,
            @JsonProperty("CreatorId") Integer creatorId,
            @JsonProperty("UpdaterId") Integer updaterId,
            @JsonProperty("CreateDate") String createDate,
            @JsonProperty("LastUpdateDate") String lastUpdateDate,
            @JsonProperty("AvatarUrl") String avatarUrl,
            @JsonProperty("HasScheduledTasks") Boolean hasScheduledTasks
    ) {}
}
