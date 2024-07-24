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
        Announcements announcements6=new Announcements();
        Announcements announcements7=new Announcements();

        Company company1 = new Company();
        Company company2 = new Company();
        Company company3=new Company();

        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();
        Project project4=new Project();
        Project project5=new Project();
        Project project6=new Project();
        Project project7=new Project();

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();
        Team team5 = new Team();
        Team team6 = new Team();
        Team team7 = new Team();

        User user1=new User();
        Credential cred1=new Credential();
        cred1.setUsername("nicholas");
        cred1.setPassword("jones");
        user1.setCredentials(cred1);
        Profile profile1=new Profile();
        profile1.setFirstName("Nicholas");
        profile1.setLastName("Jones");
        profile1.setEmail("jones@email.com");
        profile1.setPhoneNumber("(111) 111-1111");
        user1.setProfile(profile1);
        user1.setActive(true);
        user1.setStatus("JOINED");
        user1.setAdmin(true);

        User user2=new User();
        Credential cred2=new Credential();
        cred2.setUsername("jacob");
        cred2.setPassword("taylor");
        user2.setCredentials(cred2);
        Profile profile2=new Profile();
        profile2.setFirstName("Jacob");
        profile2.setLastName("Taylor");
        profile2.setEmail("taylor@email.com");
        profile2.setPhoneNumber("(222) 222-2222");
        user2.setProfile(profile2);
        user2.setActive(true);
        user2.setStatus("JOINED");
        user2.setAdmin(true);

        User user3=new User();
        Credential cred3=new Credential();
        cred3.setUsername("dakotah");
        cred3.setPassword("mccrary");
        user3.setCredentials(cred3);
        Profile profile3=new Profile();
        profile3.setFirstName("Dakotah");
        profile3.setLastName("McCrary");
        profile3.setEmail("mccrary@email.com");
        profile3.setPhoneNumber("(333) 333-3333");
        user3.setProfile(profile3);
        user3.setStatus("JOINED");
        user3.setAdmin(true);

        User user4 = new User();
        Credential cred4 = new Credential();
        cred4.setUsername("sam");
        cred4.setPassword("liao");
        user4.setCredentials(cred4);
        Profile profile4 = new Profile();
        profile4.setFirstName("Sam");
        profile4.setLastName("Liao");
        profile4.setEmail("liao@email.com");
        profile4.setPhoneNumber("(444) 444-4444");
        user4.setProfile(profile4);
        user4.setActive(true);
        user4.setStatus("JOINED");
        user4.setAdmin(true);

        User user5 = new User();
        Credential cred5 = new Credential();
        cred5.setUsername("max");
        cred5.setPassword("mcclintock");
        user5.setCredentials(cred5);
        Profile profile5 = new Profile();
        profile5.setFirstName("Max");
        profile5.setLastName("McClintock");
        profile5.setEmail("mcclintock@email.com");
        profile5.setPhoneNumber("(555) 555-5555");
        user5.setProfile(profile5);
        user5.setStatus("JOINED");
        user5.setActive(true);
        user5.setAdmin(true);


        User user6 = new User();
        Credential creds6 = new Credential();
        creds6.setUsername("worker");
        creds6.setPassword("worker");
        user6.setCredentials(creds6);
        Profile profile6 = new Profile();
        profile6.setFirstName("Mr");
        profile6.setLastName("Worker");
        profile6.setEmail("worker@email.com");
        profile6.setPhoneNumber("(888) 888-8888");
        user6.setProfile(profile6);
        user6.setActive(true);
        user6.setStatus("JOINED");

        User user7 = new User();
        Credential creds7 = new Credential();
        creds7.setUsername("admin");
        creds7.setPassword("admin");
        user7.setCredentials(creds7);
        Profile profile7 = new Profile();
        profile7.setFirstName("Mr");
        profile7.setLastName("Admin");
        profile7.setEmail("admin@email.com");
        profile7.setPhoneNumber("(000) 000-0000");
        user7.setProfile(profile7);
        user7.setActive(true);
        user7.setAdmin(true);
        user7.setStatus("JOINED");

        announcementRepo.saveAllAndFlush(Arrays.asList(
                announcement1, announcement2, announcement3, announcement4, announcement5,announcements6,announcements7));
        companyRepo.saveAllAndFlush(Arrays.asList(company1, company2,company3));
        projectRepo.saveAllAndFlush(Arrays.asList(project1, project2, project3,project4,project5,project6,project7));
        teamRepo.saveAllAndFlush(Arrays.asList(team1, team2, team3, team4, team5, team6, team7));
        userRepo.saveAllAndFlush(Arrays.asList(
                user1, user2, user3, user4, user5, user6, user7));

        announcement1.setTitle("Welcome to Cook Systems");
        announcement1.setMessage("We are starting our next cohort of FastTrack");
        announcement1.setCompany(company1);
        announcement1.setAuthor(user1);

        announcement2.setTitle("Hiring");
        announcement2.setMessage("We are starting hiring for our team");
        announcement2.setCompany(company1);
        announcement2.setAuthor(user2);

        announcement3.setTitle("Moneyy");
        announcement3.setMessage("We have funding!!");
        announcement3.setCompany(company1);
        announcement3.setAuthor(user3);

        announcement4.setTitle("Welcome to Fedex");
        announcement4.setMessage("We are glad to have new developers");
        announcement4.setCompany(company2);
        announcement4.setAuthor(user4);

        announcement5.setTitle("Moneyy");
        announcement5.setMessage("We have funding!!");
        announcement5.setCompany(company2);
        announcement5.setAuthor(user5);

        announcements6.setTitle("Welcome to Google");
        announcements6.setMessage("We are glad to have new developers");
        announcements6.setCompany(company3);
        announcements6.setAuthor(user6);

        announcements7.setTitle("Moneyy");
        announcements7.setMessage("We have funding!!");
        announcements7.setCompany(company3);
        announcements7.setAuthor(user7);

        company1.setName("Cook Systems");
        company1.setDescription("FastTrack Trainers");
        company1.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement1, announcement2,announcement3)));
        company1.setEmployees(new HashSet<User>(Arrays.asList(user1, user2,  user3)));
        company1.setTeams(new HashSet<Team>(Arrays.asList(team1, team2, team3)));

        company2.setName("Fedex");
        company2.setDescription("Global Shippers");
        company2.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement4,announcement5)));
        company2.setEmployees(new HashSet<User>(Arrays.asList( user4, user5)));
        company2.setTeams(new HashSet<Team>(Arrays.asList(team4,team5)));

        company3.setName("Google");
        company3.setDescription("Biggest tech company");
        company3.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcements6,announcements7)));
        company3.setEmployees(new HashSet<User>(Arrays.asList(user6,user7)));
        company3.setTeams(new HashSet<Team>(Arrays.asList(team6,team7)));

        project1.setName("First software project");
        project1.setDescription("building website");
        project1.setActive(true);
        project1.setTeam(team1);
        project1.setDate(Timestamp.from(Instant.now()));

        project2.setName("second software project");
        project2.setDescription("building management system");
        project2.setActive(true);
        project2.setTeam(team2);
        project2.setDate(Timestamp.from(Instant.now()));

        project3.setName("third software project");
        project3.setDescription("building dashboard");
        project3.setActive(true);
        project3.setTeam(team3);
        project3.setDate(Timestamp.from(Instant.now()));

        project4.setName("First software project");
        project4.setDescription("building website");
        project4.setActive(true);
        project4.setTeam(team4);
        project4.setDate(Timestamp.from(Instant.now()));

        project5.setName("second software project");
        project5.setDescription("building management system");
        project5.setActive(true);
        project5.setTeam(team5);
        project5.setDate(Timestamp.from(Instant.now()));

        project6.setName("third software project");
        project6.setDescription("building dashboard");
        project6.setActive(true);
        project6.setTeam(team6);
        project6.setDate(Timestamp.from(Instant.now()));

        project7.setName("First software project");
        project7.setDescription("building website");
        project7.setActive(true);
        project7.setTeam(team7);
        project7.setDate(Timestamp.from(Instant.now()));

        team1.setName("Team 1");
        team1.setDescription("1st team");
        team1.setCompany(company1);
        team1.setTeammates(new HashSet<User>(Arrays.asList(user1, user2)));
        team1.setProjects(new HashSet<Project>(Arrays.asList(project1)));

        team2.setName("Team 2");
        team2.setDescription("2nd team");
        team2.setCompany(company1);
        team2.setTeammates(new HashSet<User>(Arrays.asList(user2, user3)));

        team3.setName("Team 3");
        team3.setDescription("3rd team");
        team3.setCompany(company1);
        team3.setTeammates(new HashSet<User>(Arrays.asList(user1, user3)));
        team3.setProjects(new HashSet<Project>(Arrays.asList(project3)));

        team4.setName("Team 4");
        team4.setDescription("4th team");
        team4.setCompany(company2);
        team4.setTeammates(new HashSet<User>(Arrays.asList(user4, user5)));

        team5.setName("Team 5");
        team5.setDescription("5th team");
        team5.setCompany(company2);
        team5.setTeammates(new HashSet<User>(Arrays.asList(user4, user5)));

        team6.setName("Team 6");
        team6.setDescription("6th team");
        team6.setCompany(company3);
        team6.setTeammates(new HashSet<User>(Arrays.asList(user7, user6)));

        team7.setName("Team 7");
        team7.setDescription("7th team");
        team7.setCompany(company3);
        team7.setTeammates(new HashSet<User>(Arrays.asList(user6, user7)));
        team7.setProjects(new HashSet<Project>(Arrays.asList(project2)));

        user1.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user1.setTeams(new HashSet<Team>(Arrays.asList(team1, team3)));
        user1.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement1)));


        user2.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user2.setTeams(new HashSet<Team>(Arrays.asList(team1, team2)));
        user2.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement2)));

        user3.setCompanies(new HashSet<Company>(Arrays.asList(company1)));
        user3.setTeams(new HashSet<Team>(Arrays.asList(team2, team3)));
        user3.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement3)));

        user4.setCompanies(new HashSet<Company>(Arrays.asList(company2)));
        user4.setTeams(new HashSet<Team>(Arrays.asList(team4, team5)));
        user4.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement4)));

        user5.setCompanies(new HashSet<Company>(Arrays.asList(company2)));
        user5.setTeams(new HashSet<Team>(Arrays.asList(team4, team5)));
        user5.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcement5)));

        user6.setCompanies(new HashSet<Company>(Arrays.asList(company3)));
        user5.setTeams(new HashSet<Team>(Arrays.asList(team7, team6)));
        user6.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcements6)));

        user7.setCompanies(new HashSet<Company>(Arrays.asList(company3)));
        user5.setTeams(new HashSet<Team>(Arrays.asList(team7, team6)));
        user7.setAnnouncements(new HashSet<Announcements>(Arrays.asList(announcements7)));


        announcementRepo.saveAllAndFlush(Arrays.asList(
                announcement1, announcement2, announcement3, announcement4, announcement5,announcements6,announcements7));
        companyRepo.saveAllAndFlush(Arrays.asList(company1, company2,company3));
        projectRepo.saveAllAndFlush(Arrays.asList(project1, project2, project3,project4,project5,project6,project7));
        teamRepo.saveAllAndFlush(Arrays.asList(team1, team2, team3, team4, team5, team6, team7));
        userRepo.saveAllAndFlush(Arrays.asList(
                user1, user2, user3, user4, user5, user6, user7));
    }
}

