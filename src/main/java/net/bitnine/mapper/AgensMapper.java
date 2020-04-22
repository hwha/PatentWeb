package net.bitnine.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgensMapper {

    public List<Map<String, Object>> selectSheets();

    public List<Map<String, Object>> selectCells();
    public List<Map<String, Object>> selectNames();

    public List<Map<String, Object>> selectConnectionInfo();

    public List<Map<String, Object>> selectTree();

    public List<Map<String, Object>> selectGraph();
}
