package net.bitnine.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgensMapper {

    public List<Map<String, Object>> selectCells();
}
