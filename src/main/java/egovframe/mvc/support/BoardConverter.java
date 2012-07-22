package egovframe.mvc.support;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import egovframe.model.Board;
import egovframe.model.BoardRepository;

public class BoardConverter implements Converter<String, Board> {
    
    @Inject BoardRepository boardRepository;

    @Override
    public Board convert(String source) {
        return boardRepository.findOne(source);
    }

}
