package com.greenteam.FullStackApplication;


import com.greenteam.FullStackApplication.entities.*;
import com.greenteam.FullStackApplication.repositories.*;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

@Component
@Data
public class Seeder implements CommandLineRunner {
    private final AnnouncementsRepository announcementRepo;
    private final CompanyRepository companyRepo;
    private final ProjectRepository projectRepo;
    private final TeamRepository teamRepo;
    private final UserRepository userRepo;



    @Override
    public void run(String... args) throws Exception {
        Announcements announcement1 = new Announcements();
        Announcements announcement2 = new Announcements();
        Announcements announcement3 = new Announcements();
        Announcements announcement4 = new Announcements();
        Announcements announcement5 = new Announcements();

        Company company1 = new Company();
        Company company2 = new Company();
        Company company3=new Company();

        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();
        Team team5 = new Team();
        Team team6 = new Team();
        Team team7 = new Team();

        User user1=new User();
        Credential cred1=new Credential();
        cred1.setUsername("bobbyfootball");
        cred1.setPassword("gatorade");
        user1.setCredentials(cred1);
        Profile profile1=new Profile();
        profile1.setFirstName("Bobby");
        profile1.setLastName("Booshay");
        profile1.setEmail("foosball@email.com");
        profile1.setPhoneNumber("(111) 111-1111");
        user1.setProfile(profile1);
        user1.setActive(true);
        user1.setStatus("JOINED");

        User user2=new User();
        Credential cred2=new Credential();
        cred2.setUsername("ironman");
        cred2.setPassword("avengers");
        user2.setCredentials(cred2);
        Profile profile2=new Profile();
        profile2.setFirstName("Tony");
        profile2.setLastName("Stark");
        profile2.setEmail("ironman@email.com");
        profile2.setPhoneNumber("(222) 222-2222");
        user2.setProfile(profile2);
        user2.setActive(true);
        user2.setStatus("JOINED");

        User user3=new User();
        Credential cred3=new Credential();
        cred3.setUsername("captainamerica");
        cred3.setPassword("shield");
        user3.setCredentials(cred3);
        Profile profile3=new Profile();
        profile3.setFirstName("Steve");
        profile3.setLastName("Rogers");
        profile3.setEmail("captainamerica@email.com");
        profile3.setPhoneNumber("(333) 333-3333");
        user3.setProfile(profile3);
        user3.setStatus("JOINED");

        User user4 = new User();
        Credential cred4 = new Credential();
        cred4.setUsername("hulk");
        cred4.setPassword("smash");
        user4.setCredentials(cred4);
        Profile profile4 = new Profile();
        profile4.setFirstName("Bruce");
        profile4.setLastName("Banner");
        profile4.setEmail("hulk@email.com");
        profile4.setPhoneNumber("(444) 444-4444");
        user4.setProfile(profile4);
        user4.setActive(true);
        user4.setStatus("JOINED");

        User user5 = new User();
        Credential cred5 = new Credential();
        cred5.setUsername("thanosgauntlet");
        cred5.setPassword("stones");
        user5.setCredentials(cred5);
        Profile profile5 = new Profile();
        profile5.setFirstName("Thanos");
        profile5.setLastName("Purpleman");
        profile5.setEmail("thanos@email.com");
        profile5.setPhoneNumber("(555) 555-5555");
        user5.setProfile(profile5);
        user5.setStatus("JOINED");
        user5.setActive(true);
        user5.setAdmin(true);

        User user6 = new User();
        Credential creds6 = new Credential();
        creds6.setUsername("ultron");
        creds6.setPassword("ihatevision");
        user6.setCredentials(creds6);
        Profile profile6 = new Profile();
        profile6.setFirstName("Ultron");
        profile6.setLastName("Metalman");
        profile6.setEmail("ultron@email.com");
        profile6.setPhoneNumber("(888) 888-8888");
        user6.setProfile(profile6);
        user6.setActive(true);
        user6.setAdmin(true);
        user6.setStatus("JOINED");

        User user7 = new User();
        Credential creds7 = new Credential();
        creds7.setUsername("Jacob");
        creds7.setPassword("code");
        user7.setCredentials(creds7);
        Profile profile7 = new Profile();
        profile7.setFirstName("Jacob");
        profile7.setLastName("Taylor");
        profile7.setEmail("jacob@email.com");
        profile7.setPhoneNumber("(000) 000-0000");
        user7.setProfile(profile7);
        user7.setActive(true);
        user7.setAdmin(true);
        user7.setStatus("JOINED");

        announcementRepo.saveAllAndFlush(Arrays.asList(
                announcement1, announcement2, announcement3, announcement4, announcement5));
        companyRepo.saveAllAndFlush(Arrays.asList(company1, company2));
        projectRepo.saveAllAndFlush(Arrays.asList(project1, project2, project3));
        teamRepo.saveAllAndFlush(Arrays.asList(team1, team2, team3, team4, team5, team6, team7));
        userRepo.saveAllAndFlush(Arrays.asList(
                user1, user2, user3, user4, user5, user6, user7));

        announcement1.setTitle("Welcome to Jacob Solutions");
        announcement1.setMessage("We are a new software startup");
        announcement1.setCompany(company1);
        announcement1.setAuthor(user7);

        announcement2.setTitle("Hiring");
        announcement2.setMessage("We are starting hiring for our team");
        announcement2.setCompany(company1);
        announcement2.setAuthor(user6);

        announcement3.setTitle("Moneyy");
        announcement3.setMessage("We have funding!!");
        announcement3.setCompany(company1);
        announcement3.setAuthor(user5);

        announcement4.setTitle("Welcome to Taylor Solutions");
        announcement4.setMessage("We are a new software startup");
        announcement4.setCompany(company2);
        announcement4.setAuthor(user4);

        announcement5.setTitle("Moneyy");
        announcement5.setMessage("We have funding!!");
        announcement5.setCompany(company2);
        announcement5.setAuthor(user3);

        company1.setName("Cook Systems");
        company1.setDescription("start up 1");
        company1.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement1, announcement2)));
        company1.setEmployees(new HashSet<User>(Arrays.asList(user1, user2,  user7)));
        company1.setTeams(new HashSet<Team>(Arrays.asList(team1, team2, team3, team4, team5, team6)));

        company2.setName("Fedex");
        company2.setDescription("start up 2");
        company2.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement3)));
        company2.setEmployees(new HashSet<User>(Arrays.asList(user3, user4, user5, user6)));
        company2.setTeams(new HashSet<Team>(Arrays.asList(team7)));

        company3.setName("Google");
        company3.setDescription("start up 2");
        company3.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement3)));
        company3.setEmployees(new HashSet<User>(Arrays.asList(user3, user4, user5, user6)));
        company3.setTeams(new HashSet<Team>(Arrays.asList(team7)));

        project1.setName("First software project");
        project1.setDescription("building website");
        project1.setActive(true);
        project1.setTeam(team1);
        project1.setDate(Timestamp.from(Instant.now()));

        project2.setName("second software project");
        project2.setDescription("building management system");
        project2.setActive(true);
        project2.setTeam(team7);
        project2.setDate(Timestamp.from(Instant.now()));

        project3.setName("third software project");
        project3.setDescription("building dashboard");
        project3.setActive(true);
        project3.setTeam(team3);
        project3.setDate(Timestamp.from(Instant.now()));

        team1.setName("Team 1");
        team1.setDescription("1st team");
        team1.setCompany(company1);
        team1.setTeammates(new HashSet<User>(Arrays.asList(user1, user2)));
        team1.setProjects(new HashSet<Project>(Arrays.asList(project1)));

        team2.setName("Team 2");
        team2.setDescription("2nd team");
        team2.setCompany(company1);
        team2.setTeammates(new HashSet<User>(Arrays.asList(user2, user5)));

        team3.setName("Team 3");
        team3.setDescription("3rd team");
        team3.setCompany(company1);
        team3.setTeammates(new HashSet<User>(Arrays.asList(user4, user3)));
        team3.setProjects(new HashSet<Project>(Arrays.asList(project3)));

        team4.setName("Team 4");
        team4.setDescription("4th team");
        team4.setCompany(company1);
        team4.setTeammates(new HashSet<User>(Arrays.asList(user1, user3)));

        team5.setName("Team 5");
        team5.setDescription("5th team");
        team5.setCompany(company1);
        team5.setTeammates(new HashSet<User>(Arrays.asList(user6, user7)));

        team6.setName("Team 6");
        team6.setDescription("6th team");
        team6.setCompany(company1);
        team6.setTeammates(new HashSet<User>(Arrays.asList(user3, user4, user5, user7)));

        team7.setName("Team 7");
        team7.setDescription("7th team");
        team7.setCompany(company2);
        team7.setTeammates(new HashSet<User>(Arrays.asList(user1, user2, user3)));
        team7.setProjects(new HashSet<Project>(Arrays.asList(project2)));

        user1.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user1.setTeams(new HashSet<Team>(Arrays.asList(team1, team4)));


        user2.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user2.setTeams(new HashSet<Team>(Arrays.asList(team1, team2)));

        user3.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user3.setTeams(new HashSet<Team>(Arrays.asList(team4, team6)));
        user3.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement5)));

        user4.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user4.setTeams(new HashSet<Team>(Arrays.asList(team3, team6)));
        user4.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement4)));

        user5.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user5.setTeams(new HashSet<Team>(Arrays.asList(team2, team6)));
        user5.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement3)));

        user6.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user5.setTeams(new HashSet<Team>(Arrays.asList(team2, team6)));
        user6.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement2)));

        user7.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user5.setTeams(new HashSet<Team>(Arrays.asList(team2, team6)));
        user7.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement1)));


        announcementRepo.saveAllAndFlush(Arrays.asList(
                announcement1, announcement2, announcement3, announcement4, announcement5));
        companyRepo.saveAllAndFlush(Arrays.asList(company1, company2));
        projectRepo.saveAllAndFlush(Arrays.asList(project1, project2, project3));
        teamRepo.saveAllAndFlush(Arrays.asList(team1, team2, team3, team4, team5, team6, team7));
        userRepo.saveAllAndFlush(Arrays.asList(
                user1, user2, user3, user4, user5, user6, user7));
    }
}

