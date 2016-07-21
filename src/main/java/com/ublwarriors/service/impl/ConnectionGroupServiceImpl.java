package com.ublwarriors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ublwarriors.guacamole.dao.ConnectionGroupMapper;
import com.ublwarriors.guacamole.model.ConnectionGroup;
import com.ublwarriors.guacamole.model.ConnectionGroupExample;
import com.ublwarriors.service.ConnectionGroupService;
@Service
public class ConnectionGroupServiceImpl implements ConnectionGroupService {

	@Autowired 
	ConnectionGroupMapper groupMapper;
	
	@Override
	public ConnectionGroup selectConnectionGroup(ConnectionGroup conn) {
		Integer groupid = conn.getConnectionGroupId();
		ConnectionGroup result;
		if(groupid != null)
		{
			result = groupMapper.selectByPrimaryKey(groupid);
		}else{
			String name = conn.getConnectionGroupName();
			ConnectionGroupExample exam = new ConnectionGroupExample();
			exam.or().andConnectionGroupNameEqualTo(name);
			List<ConnectionGroup> groups = groupMapper.selectByExample(exam);
			if(groups.size()!= 0)
			{
				result = groups.get(0);
			}else {
				result = null;
			}
		}
		return result;
	}

	@Override
	public ConnectionGroup selectConnectionGroupById(int connectionGroupId) {
			ConnectionGroup result = groupMapper.selectByPrimaryKey(connectionGroupId);
			return result;
	}

	@Override
	public ConnectionGroup editConnectionGroup(ConnectionGroup conn) {
		Integer groupid = conn.getConnectionGroupId();
		ConnectionGroup result;
		if(groupid != null)
		{
			int affectedRows = groupMapper.updateByPrimaryKeySelective(conn);
		}else{
			String name = conn.getConnectionGroupName();
			ConnectionGroupExample exam = new ConnectionGroupExample();
			exam.or().andConnectionGroupNameEqualTo(name);
			List<ConnectionGroup> groups = groupMapper.selectByExample(exam);
			if(groups.size()!= 0)
			{
				int affectedRows = groupMapper.updateByPrimaryKeySelective(groups.get(0));
			}else {
				result = null;
			}
		}
		return groupMapper.selectByPrimaryKey(groupid);
	}

	@Override
	public ConnectionGroup addConnectionGroup(ConnectionGroup group) {
		int affectedRows = groupMapper.insertSelective(group);
		return selectConnectionGroup(group);
	}

	@Override
	public ConnectionGroup deleteConnectionGroup(ConnectionGroup group) {
		int affectedRows = groupMapper.deleteByPrimaryKey(group.getConnectionGroupId());
		return null;
	}

}
