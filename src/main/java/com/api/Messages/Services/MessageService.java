/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.Messages.Services;
import com.api.Messages.Model.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author PC
 */
public class MessageService {
   public List<Message> messages = new ArrayList<>();
    public Long nextId = 1L;

    public MessageService() {
        messages.add(new Message(nextId++, "Mariana", "Quiero dinero", LocalDateTime.now()));
        messages.add(new Message(nextId++, "Mariana", "Quiero un trabajo", LocalDateTime.now()));
    }
    
    public List<Message> getAllMessages(){
        return messages;
    }
    public Optional<Message> getMessageById(Long id) {
        return messages.stream().filter(msg->msg.getId().equals(id)).findFirst();
    }
    public Message addMessage(Message msg) {
    msg.setId(nextId++);
    messages.add(msg);
    return msg;
    }
    public Message updateMessage(Long id, Message updateMessage){
        Optional<Message> oldMessage = getMessageById(id);
        if (oldMessage.isPresent()){
            Message msg = oldMessage.get();
            msg.setUser(updateMessage.getUser());
            msg.setMessage(updateMessage.getMessage());
            return msg;
        }
        return null;
    }
    
    public boolean deleteMessage(Long id){
        return messages.removeIf(msg->msg.getId().equals(id));
    }
   
}  

