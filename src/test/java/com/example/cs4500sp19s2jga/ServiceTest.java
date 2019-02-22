package com.example.cs4500sp19s2jga;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.cs4500sp19s2jga.controllers.ServiceController;
import com.example.cs4500sp19s2jga.models.Service;
import com.example.cs4500sp19s2jga.models.ServiceCategory;
import com.example.cs4500sp19s2jga.services.ServiceService;

@RunWith(SpringRunner.class)
@WebMvcTest(ServiceController.class)
public class ServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceService serviceService;
    @Test
    public void testFindServiceById() throws Exception {
        ServiceCategory engineering = new ServiceCategory(123, "Engineering");
        ServiceCategory training = new ServiceCategory(234, "Training");
        List<ServiceCategory> categories = Arrays.asList(engineering, training);
        Service webDevService = new Service(345, "Web Development");
        webDevService.setServiceCategories(categories);
        when(serviceService.findServiceById(345)).thenReturn(webDevService);
        this.mockMvc
            .perform(get("/api/services/123"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(123)))
            .andExpect(jsonPath("$.serviceCategories", hasSize(2)))
            .andExpect(jsonPath("$.serviceCategories[*].title", containsInAnyOrder("Engineering", "Training")));
    }
}
