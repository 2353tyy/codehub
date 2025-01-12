package com.huazai.subject.domain.convert;

import com.huazai.subject.domain.entity.SubjectAnswerBO;
import com.huazai.subject.infra.basic.entity.SubjectMultiple;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-07T15:07:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Oracle Corporation)"
)
public class MultipleSubjectConverterImpl implements MultipleSubjectConverter {

    @Override
    public SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectMultiple subjectMultiple = new SubjectMultiple();

        subjectMultiple.setOptionType( subjectAnswerBO.getOptionType() );
        subjectMultiple.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectMultiple.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectMultiple;
    }
}
