package com.huazai.subject.application.convert;

import com.huazai.subject.application.dto.SubjectAnswerDTO;
import com.huazai.subject.domain.entity.SubjectAnswerBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-07T15:07:07+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Oracle Corporation)"
)
public class SubjectAnswerDTOConverterImpl implements SubjectAnswerDTOConverter {

    @Override
    public List<SubjectAnswerBO> convertDtoToBo(List<SubjectAnswerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( dtoList.size() );
        for ( SubjectAnswerDTO subjectAnswerDTO : dtoList ) {
            list.add( subjectAnswerDTOToSubjectAnswerBO( subjectAnswerDTO ) );
        }

        return list;
    }

    protected SubjectAnswerBO subjectAnswerDTOToSubjectAnswerBO(SubjectAnswerDTO subjectAnswerDTO) {
        if ( subjectAnswerDTO == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setOptionType( subjectAnswerDTO.getOptionType() );
        subjectAnswerBO.setOptionContent( subjectAnswerDTO.getOptionContent() );
        if ( subjectAnswerDTO.getIsCorrect() != null ) {
            subjectAnswerBO.setIsCorrect( Integer.parseInt( subjectAnswerDTO.getIsCorrect() ) );
        }

        return subjectAnswerBO;
    }
}
