package orz.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import orz.zerock.jdbcex.dao.TodoDAO;
import orz.zerock.jdbcex.domain.TodoVO;
import orz.zerock.jdbcex.dto.TodoDTO;
import orz.zerock.jdbcex.util.MapperUtil;

@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao= new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // System.out.println("todoVO : " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
    }
}
