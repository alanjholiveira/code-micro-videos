package br.com.codeflix.videos.integration;

import br.com.codeflix.videos.domain.dto.CastMemberDTO;
import br.com.codeflix.videos.domain.entity.CastMember;
import br.com.codeflix.videos.infrastructure.enums.TypeDirectorActorEnum;
import br.com.codeflix.videos.infrastructure.repository.CastMemberRepository;
import br.com.codeflix.videos.infrastructure.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CastMemberControllerIT {

    private static final String URL_API = "/api/v1/cast_members";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CastMemberRepository repository;

    private List<CastMember> castMembers;
    private CastMemberDTO dto1;
    private CastMember entity1;

    @BeforeEach
    public void setup() {

        dto1 = new CastMemberDTO();
        dto1.setId(TestUtil.ID);
        dto1.setName(TestUtil.NAME);
        dto1.setType(TypeDirectorActorEnum.TYPE_ACTOR);

        entity1 = new CastMember();
        entity1.setId(TestUtil.ID);
        entity1.setName(TestUtil.NAME);
        entity1.setType(TypeDirectorActorEnum.TYPE_ACTOR);

        castMembers = new ArrayList<>();
        castMembers.addAll(Arrays.asList(entity1, entity1));

        BDDMockito.when(repository.findAll()).thenReturn(castMembers);

        BDDMockito.when(repository.findById(TestUtil.ID)).thenReturn(Optional.of(entity1));

        BDDMockito.when(repository.save(entity1)).thenReturn(entity1);


    }

    @Test
    public void testListAllEndpoint_thenStatus200() throws Exception {
        mockMvc.perform(get(URL_API))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id", hasSize(2)));
    }

    @Test
    public void testSave_thenStatus201() throws Exception {

        mockMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(dto1)))
                .andExpect(status().isCreated());

    }

    @Test
    public void testSave_error_thenStatus400() throws Exception {
        dto1.setId(null);
        dto1.setName(null);

        mockMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(dto1)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testEdit_thenStatus200() throws Exception {

        mockMvc.perform(put(URL_API + "/" + dto1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(dto1)))
                .andExpect(status().isOk());

    }

    @Test
    public void testDelete_thenStatus204() throws Exception {

        mockMvc.perform(delete(URL_API + "/" + dto1.getId()))
                .andExpect(status().isNoContent());
    }


}
