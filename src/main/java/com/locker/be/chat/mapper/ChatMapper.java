package com.locker.be.chat.mapper;

import com.locker.be.chat.dto.ChatMessageDto;
import com.locker.be.chat.dto.ChatRoomDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {

    List<ChatRoomDto.RoomListItem> selectRooms(Long userId);

    void insertRoom(ChatRoomDto.RoomInsertParam param);

    void exitRoom(ChatRoomDto.RoomExitParam param);

    List<ChatMessageDto.ChatMessage> selectMessages(ChatMessageDto.MessageSelectParam param);

    int insertMessage(ChatMessageDto.MessageInsertParam param);
}
