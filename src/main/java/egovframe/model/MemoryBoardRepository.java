package egovframe.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryBoardRepository implements BoardRepository, InitializingBean {
    
    Map<String, Board> boards = new HashMap<String, Board>();
    
    @Override
    public void afterPropertiesSet() throws Exception {
        Board notice = new Board("notice", "공지사항");
        notice.writing(new Post("공지사항 게시판입니다.", "꼬박꼬박 보시오!", "arawn"));
        notice.writing(new Post("자기소개를 해주세요.", "안하면 강퇴!", "arawn"));
        notice.writing(new Post("말머리를 지켜주세요!", "안지키면 강퇴!", "arawn"));
        boards.put(notice.getName(), notice);
        
        Board freetalking = new Board("freetalking", "자유게시판");
        freetalking.writing(new Post("자유게시판입니다.", "", "arawn"));
        freetalking.writing(new Post("에티켓을 지켜주세요!", "안지키면 강퇴!", "arawn"));
        boards.put(freetalking.getName(), freetalking);
    }
    
    @Override
    public Iterable<Board> findAll() {
        return boards.values();
    }

    @Override
    public Board findOne(String boardName) {
        if(!boards.containsKey(boardName))
            throw new IllegalArgumentException("게시판(" + boardName + ")을 찾을 수 없습니다.");
        
        return boards.get(boardName);
    }

}
