package net.bitnine.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.bitnine.agensgraph.util.Jsonb;
import net.bitnine.mapper.AgensMapper;

@Service
public class AgensService {

    AgensMapper agensMapper;

    @Autowired
    public AgensService(AgensMapper agensMapper) {
        this.agensMapper = agensMapper;
    }

    public Map<String, Object> getGraph() {
        Map<String, Object> result = Maps.newHashMap();

        List<Map<String, Object>> nodeList = Lists.newArrayList();
        List<Map<String, Object>> sheets = agensMapper.selectSheets().stream().map(resultSet -> {
            return resultSet.entrySet().stream().map(this::convertJsonbToObject)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).collect(Collectors.toList());
        nodeList.addAll(sheets);

        List<Map<String, Object>> cells = agensMapper.selectCells().stream().map(resultSet -> {
            return resultSet.entrySet().stream().map(this::convertJsonbToObject)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).collect(Collectors.toList());
        nodeList.addAll(cells);

        List<Map<String, Object>> names = agensMapper.selectNames().stream().map(resultSet -> {
            return resultSet.entrySet().stream().map(this::convertJsonbToObject)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).collect(Collectors.toList());
        nodeList.addAll(names);

        List<Map<String, Object>> connectionInfos = agensMapper.selectConnectionInfo().stream().map(resultSet -> {
            return resultSet.entrySet().stream().map(this::convertJsonbToObject)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).collect(Collectors.toList());

        result.put("nodes", nodeList);
        result.put("links", connectionInfos);
        return result;
    }

    public List<Map<String, Object>> getCells() {
        List<Map<String, Object>> selectCells = agensMapper.selectCells();
        return selectCells.stream().map(resultSet -> {
            return resultSet.entrySet().stream().map(this::convertJsonbToObject)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).collect(Collectors.toList());
    }

    public List<Map<String, Object>> getTree() {
        List<Map<String, Object>> selectTree = agensMapper.selectTree();
        return selectTree.stream().map(resultSet -> {
            return resultSet.entrySet().stream().map(this::convertJsonbToObject)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).collect(Collectors.toList());
    }

    public Entry<String, Object> convertJsonbToObject(Entry<String, Object> entry) {
        Jsonb value = (Jsonb) entry.getValue();
        entry.setValue(value.getTypedValue());
        return entry;
    }
}


