package ku.message.service;

import ku.message.dto.MessageDto;
import ku.message.model.Message;
import ku.message.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    // map dao to dto
    public List<MessageDto> getMessages() {
        List<Message> messages = repository.findAll();

        List<MessageDto> dtos = messages
                .stream()
                .map(dao -> modelMapper.map(dao, MessageDto.class))
                .collect(Collectors.toList());

        return dtos;
    }

    // map dto to dao
    public void createMessage(MessageDto messageDto, String username) {
        Message message = modelMapper.map(messageDto, Message.class);
        message.setUser(username);
        message.setCreatedAt(Instant.now());
        repository.save(message);
    }
}
