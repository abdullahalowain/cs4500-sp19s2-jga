package com.example.cs4500sp19s2jga;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.cs4500sp19s2jga.models.User;
import com.example.cs4500sp19s2jga.services.DefaultUserService;
import com.example.cs4500sp19s2jga.services.UserController;
import com.example.cs4500sp19s2jga.services.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    DefaultUserService userService;
    
    @Test
    @Disabled
    public void testFindAllUsers() throws Exception {
       
        
        List<User> empList = buildEmployees();
        when(userService.findAllUsers()).thenReturn(empList);
       
        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");

        verify(userService).findAllUsers();
        
//        TypeToken<List<User>> token = new TypeToken<>() {
//        };


        
//        mockMvc.perform(get("/")).andExpect(status().isOk());
    }
    
    private List<User> buildEmployees() {
        User e1 = new User(123, "alice", "password", "Alice", "Wonderland");
        List<User> empList = Arrays.asList(e1);
        return empList;
    }
}
