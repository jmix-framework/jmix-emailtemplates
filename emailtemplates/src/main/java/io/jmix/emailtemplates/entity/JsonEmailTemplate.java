/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.emailtemplates.entity;


import io.jmix.core.entity.annotation.Listeners;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.reports.entity.Report;

import javax.persistence.*;

@Entity(name = "emailtemplates_JsonEmailTemplate")
@JmixEntity
@DiscriminatorValue("emailtemplates_JsonEmailTemplate")
@Listeners("emailtemplates_JsonEmailTemplateDetachListener")
public class JsonEmailTemplate extends EmailTemplate {

    @Lob
    @Column(name = "HTML")
    protected String html;

    @Lob
    @Column(name = "REPORT_XML")
    protected String reportXml;

    @Transient
    private TemplateReport templateReport;

    @Transient
    private Report report;

    public void setHtml(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setReportXml(String reportXml) {
        this.reportXml = reportXml;
    }

    public String getReportXml() {
        return reportXml;
    }

    public JsonEmailTemplate() {
        setType(TemplateType.JSON);
        setUseReportSubject(true);
    }

    @Override
    public Report getReport() {
        return report;
    }

    @Override
    public void setEmailBodyReport(TemplateReport emailBodyReport) {
        this.templateReport = emailBodyReport;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public TemplateReport getEmailBodyReport() {
        return templateReport;
    }
}