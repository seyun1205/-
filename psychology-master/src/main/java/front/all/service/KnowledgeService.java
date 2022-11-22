package front.all.service;

import front.all.pojo.Knowledge;

import java.util.List;

public interface KnowledgeService {
    List<Knowledge> selectAll();

    boolean addKnowledge(String content_title,String content);

    boolean deleteKnowledge(String content_title);

    List<Knowledge> getKnowledgeByContent(String searchStr);

    boolean changeKnowledge(String content_title, String content, String new_title);
}
