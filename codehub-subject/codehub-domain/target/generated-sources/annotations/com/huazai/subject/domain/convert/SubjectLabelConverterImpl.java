package com.huazai.subject.domain.convert;

import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-07T15:07:03+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Oracle Corporation)"
)
public class SubjectLabelConverterImpl implements SubjectLabelConverter {

    @Override
    public SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setId( subjectLabelBO.getId() );
        subjectLabel.setLabelName( subjectLabelBO.getLabelName() );
        subjectLabel.setSortNum( subjectLabelBO.getSortNum() );

        return subjectLabel;
    }

    @Override
    public SubjectLabelBO convertBoToLabel(SubjectLabel subjectLabel) {
        if ( subjectLabel == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        subjectLabelBO.setId( subjectLabel.getId() );
        subjectLabelBO.setLabelName( subjectLabel.getLabelName() );
        subjectLabelBO.setSortNum( subjectLabel.getSortNum() );

        return subjectLabelBO;
    }
}
