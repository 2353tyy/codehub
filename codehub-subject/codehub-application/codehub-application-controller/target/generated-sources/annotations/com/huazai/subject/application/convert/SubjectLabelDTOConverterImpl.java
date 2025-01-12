package com.huazai.subject.application.convert;

import com.huazai.subject.application.dto.SubjectLabelDTO;
import com.huazai.subject.domain.entity.SubjectLabelBO;
import com.huazai.subject.infra.basic.entity.SubjectLabel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-07T15:07:07+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Oracle Corporation)"
)
public class SubjectLabelDTOConverterImpl implements SubjectLabelDTOConverter {

    @Override
    public SubjectLabelBO convertDtoToBo(SubjectLabelDTO subjectLAbelDTO) {
        if ( subjectLAbelDTO == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        subjectLabelBO.setId( subjectLAbelDTO.getId() );
        subjectLabelBO.setLabelName( subjectLAbelDTO.getLabelName() );
        subjectLabelBO.setCategoryId( subjectLAbelDTO.getCategoryId() );
        subjectLabelBO.setSortNum( subjectLAbelDTO.getSortNum() );

        return subjectLabelBO;
    }

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
    public List<SubjectLabelDTO> convertBoToDto(List<SubjectLabelBO> subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        List<SubjectLabelDTO> list = new ArrayList<SubjectLabelDTO>( subjectLabelBO.size() );
        for ( SubjectLabelBO subjectLabelBO1 : subjectLabelBO ) {
            list.add( subjectLabelBOToSubjectLabelDTO( subjectLabelBO1 ) );
        }

        return list;
    }

    protected SubjectLabelDTO subjectLabelBOToSubjectLabelDTO(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabelDTO subjectLabelDTO = new SubjectLabelDTO();

        subjectLabelDTO.setId( subjectLabelBO.getId() );
        subjectLabelDTO.setCategoryId( subjectLabelBO.getCategoryId() );
        subjectLabelDTO.setLabelName( subjectLabelBO.getLabelName() );
        subjectLabelDTO.setSortNum( subjectLabelBO.getSortNum() );

        return subjectLabelDTO;
    }
}
