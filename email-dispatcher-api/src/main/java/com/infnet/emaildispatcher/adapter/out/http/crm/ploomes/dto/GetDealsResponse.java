package com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetDealsResponse(
        @JsonProperty("@odata.context") String odataContext,
        List<DealData> value
) {
    public record DealData(
            @JsonProperty("Id") Integer id,
            @JsonProperty("Title") String title,
            @JsonProperty("AccountId") Integer accountId,
            @JsonProperty("ContactId") Integer contactId,
            @JsonProperty("ContactName") String contactName,
            @JsonProperty("PersonId") Integer personId,
            @JsonProperty("PersonName") String personName,
            @JsonProperty("PipelineId") Integer pipelineId,
            @JsonProperty("StageId") Integer stageId,
            @JsonProperty("StatusId") Integer statusId,
            @JsonProperty("FirstTaskId") Integer firstTaskId,
            @JsonProperty("FirstTaskDate") String firstTaskDate,
            @JsonProperty("HasScheduledTasks") Boolean hasScheduledTasks,
            @JsonProperty("OriginId") Integer originId,
            @JsonProperty("OwnerId") Integer ownerId,
            @JsonProperty("StartDate") String startDate,
            @JsonProperty("FinishDate") String finishDate,
            @JsonProperty("Amount") Double amount,
            @JsonProperty("DaysInStage") Integer daysInStage,
            @JsonProperty("HoursInStage") Integer hoursInStage,
            @JsonProperty("Editable") Boolean editable,
            @JsonProperty("Deletable") Boolean deletable,
            @JsonProperty("CreatorId") Integer creatorId,
            @JsonProperty("CreateDate") String createDate,
            @JsonProperty("LastUpdateDate") String lastUpdateDate,
            @JsonProperty("DealNumber") Integer dealNumber
    ) {}
}
