package net.madsn.frameworktest.jhipster.web.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

import net.madsn.frameworktest.jhipster.Application;
import net.madsn.frameworktest.jhipster.domain.TeamMember;
import net.madsn.frameworktest.jhipster.repository.TeamMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TeamMemberResource REST controller.
 *
 * @see TeamMemberResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class TeamMemberResourceTest {

    private static final String DEFAULT_INITIALS = "SAMPLE_TEXT";
    private static final String UPDATED_INITIALS = "UPDATED_TEXT";
    private static final String DEFAULT_NAME = "SAMPLE_TEXT";
    private static final String UPDATED_NAME = "UPDATED_TEXT";

    @Inject
    private TeamMemberRepository teamMemberRepository;

    private MockMvc restTeamMemberMockMvc;

    private TeamMember teamMember;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        TeamMemberResource teamMemberResource = new TeamMemberResource();
        ReflectionTestUtils.setField(teamMemberResource, "teamMemberRepository", teamMemberRepository);
        this.restTeamMemberMockMvc = MockMvcBuilders.standaloneSetup(teamMemberResource).build();
    }

    @Before
    public void initTest() {
        teamMember = new TeamMember();
        teamMember.setInitials(DEFAULT_INITIALS);
        teamMember.setName(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createTeamMember() throws Exception {
        // Validate the database is empty
        assertThat(teamMemberRepository.findAll()).hasSize(0);

        // Create the TeamMember
        restTeamMemberMockMvc.perform(post("/api/teamMembers")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(teamMember)))
                .andExpect(status().isOk());

        // Validate the TeamMember in the database
        List<TeamMember> teamMembers = teamMemberRepository.findAll();
        assertThat(teamMembers).hasSize(1);
        TeamMember testTeamMember = teamMembers.iterator().next();
        assertThat(testTeamMember.getInitials()).isEqualTo(DEFAULT_INITIALS);
        assertThat(testTeamMember.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void getAllTeamMembers() throws Exception {
        // Initialize the database
        teamMemberRepository.saveAndFlush(teamMember);

        // Get all the teamMembers
        restTeamMemberMockMvc.perform(get("/api/teamMembers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(teamMember.getId().intValue()))
                .andExpect(jsonPath("$.[0].initials").value(DEFAULT_INITIALS.toString()))
                .andExpect(jsonPath("$.[0].name").value(DEFAULT_NAME.toString()));
    }

    @Test
    @Transactional
    public void getTeamMember() throws Exception {
        // Initialize the database
        teamMemberRepository.saveAndFlush(teamMember);

        // Get the teamMember
        restTeamMemberMockMvc.perform(get("/api/teamMembers/{id}", teamMember.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(teamMember.getId().intValue()))
            .andExpect(jsonPath("$.initials").value(DEFAULT_INITIALS.toString()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingTeamMember() throws Exception {
        // Get the teamMember
        restTeamMemberMockMvc.perform(get("/api/teamMembers/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTeamMember() throws Exception {
        // Initialize the database
        teamMemberRepository.saveAndFlush(teamMember);

        // Update the teamMember
        teamMember.setInitials(UPDATED_INITIALS);
        teamMember.setName(UPDATED_NAME);
        restTeamMemberMockMvc.perform(post("/api/teamMembers")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(teamMember)))
                .andExpect(status().isOk());

        // Validate the TeamMember in the database
        List<TeamMember> teamMembers = teamMemberRepository.findAll();
        assertThat(teamMembers).hasSize(1);
        TeamMember testTeamMember = teamMembers.iterator().next();
        assertThat(testTeamMember.getInitials()).isEqualTo(UPDATED_INITIALS);
        assertThat(testTeamMember.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void deleteTeamMember() throws Exception {
        // Initialize the database
        teamMemberRepository.saveAndFlush(teamMember);

        // Get the teamMember
        restTeamMemberMockMvc.perform(delete("/api/teamMembers/{id}", teamMember.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<TeamMember> teamMembers = teamMemberRepository.findAll();
        assertThat(teamMembers).hasSize(0);
    }
}
