package pl.teai.pracadomowatydzien3.dzw.listofcars;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarApiTest {
    public static final String HTTP_LOCALHOST_8080_CARS = "http://localhost:8080/cars";

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_get_list_of_cars() throws Exception {
        mockMvc.perform(get(HTTP_LOCALHOST_8080_CARS))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    public void should_get_car_by_id() throws Exception {
        mockMvc.perform(get(HTTP_LOCALHOST_8080_CARS + "/{id}",1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mark", Matchers.containsString("Audi")));
    }

    @Test
    public void should_get_car_color_white() throws Exception {
        mockMvc.perform(get(HTTP_LOCALHOST_8080_CARS + "/color")
                .param("color", "white"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.color", Matchers.containsString("white")));
    }


    @Test
    public void should_add_car() throws Exception {
        mockMvc.perform(post(HTTP_LOCALHOST_8080_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 6,\"mark\": \"Toyota\",\"model\": \"RV4\",\"color\": \"white\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(get(HTTP_LOCALHOST_8080_CARS))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));

        mockMvc.perform(delete(HTTP_LOCALHOST_8080_CARS+ "/{id}",6))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(6)));

    }

    @Test
    public void should_put_car() throws Exception {

        mockMvc.perform(post(HTTP_LOCALHOST_8080_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 6,\"mark\": \"Toyota\",\"model\": \"RV4\",\"color\": \"white\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(put(HTTP_LOCALHOST_8080_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 6,\"mark\": \"BMV\",\"model\": \"RV4\",\"color\": \"white\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(get(HTTP_LOCALHOST_8080_CARS + "/{id}",6))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mark", Matchers.containsString("BMV")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(6)));

        mockMvc.perform(delete(HTTP_LOCALHOST_8080_CARS+ "/{id}",6))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(6)));

    }

    @Test
    public void should_delete_car() throws Exception {

        mockMvc.perform(post(HTTP_LOCALHOST_8080_CARS)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 6,\"mark\": \"Toyota\",\"model\": \"RV4\",\"color\": \"white\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(delete(HTTP_LOCALHOST_8080_CARS+ "/{id}",6))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(6)));

    }




}
