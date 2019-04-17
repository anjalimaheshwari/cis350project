package com.example.personalwellness;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class ResourceDB implements Serializable {
    private List<User> userDB = new ArrayList<User>();
    private List<Resource> resourceList = new ArrayList<Resource>();

    public ResourceDB() {
        resourceList.add(new Resource("Grief Referrals: " +
                "Penn Students of AMF (Actively Moving Forward)","grief",
                "1) a peer-led Grief Support Group for Penn students who are coping with the illness or death of a loved one to connect with others “who get it,”\n" +
                        "2) a Service Group open to ALL students to go to service events together throughout the Philly area, and\n" +
                        "3) opportunities for faculty members to serve as mentors to support group members. Over the past 4 years, we have had 10-20 consistent support group members and 20-50 service group members each year.\n" +
                        "This is not just a Penn issue. Between 35-48% of college students have grieved the death of a loved one in the last 2 years. For more info, go to:  http://www.youtube.com/watch?v=ZxgnQUIyMow\n", "mh", "",
                "https://pennstudentsofamf.weebly.com/", 39.956530, -75.193810, null, false));
        resourceList.add(new Resource("Penn Women’s Center",
                "h", "We are affiliated with a number of centers and programs on " +
                "campus, with the goal of centralizing women, gender, and sexuality focused resources. " +
                "We encourage you to look at our support services and affiliated groups for further information. " +
                "We offer programs related to: " +
                "Career Development, Stress Management, Parenting, Sexual Violence Prevention, and Health and Wellness." +
                "\n", "mh", "3643 Locust Walk", "http://www.vpul.upenn.edu/pwc",
                39.952430, -75.196730, "(215) 898-8611", false));
        resourceList.add(new Resource("The Office of Alcohol & Other Drug Program Initiatives (AOD)",
                "h", "The mission of the Office of Alcohol and Other Drug Program Initiatives " +
                "is to reduce harm related to alcohol and other drug use at the University of Pennsylvania.  " +
                "Key efforts focus on education, prevention and confidential, non-judgmental brief interventions for both individual Penn students and student groups.  " +
                "In accordance with this mission, the office oversees policies, environmental management efforts and educational programs that encourage a safe and healthy " +
                "campus environment for students.", "mh",
                "3611 Locust Walk", "https://www.vpul.upenn.edu/alcohol/",
                39.954100, -75.211920, "(215) 573-3525", false));
        resourceList.add(new Resource("Penn Benjamins Peer Support",
                "h", "Penn Benjamins is a peer support organization run by students, for students. They offer confidential peer-to-peer talking and referral services to any member of the Penn undergraduate community.\n" +
                "·         *Penn Benjamins peer counselors are not licensed professional counselors. *Penn Benjamins is an independent student group. *No appointment necessary. Hours:\n" +
                "·         Sundays 8-11pm Harnwell First Floor Library\n" +
                "·         Mondays 8-11pm Harnwell First Floor Library\n" +
                "·         Tuesdays 8-11pm Harnwell First Floor Library\n" +
                "·         Wednesdays 8-11pm Chaplain's Office\n" +
                "·         Thursdays 8-11pm Chaplain's Office\n",
                "mh", "Various Philadelphia locations",
                "pennbenjamins.org", 39.954100, -75.211920, "(901) 338-0828", false));
        //diet
        resourceList.add(new Resource("The Penn Program for Mindfulness, Stress Management, and More",
                "h", "The Penn Program for Mindfulness teaches you how to manage the stresses of life with powerful " +
                "mindfulness-based tools. Our programs will teach you how to actively manage the range of challenges that you face in " +
                "life while you learn to enhance well-being, improve relationships, and increase productivity.", "d",
                "Various Philadelphia locations",
                "http://www.pennmedicine.org/stress/ ", 39.952049, -75.173492, "800-789-PENN(7366)", false));

        //seeking community
        resourceList.add(new Resource("Lesbian Gay Bisexual Transgender Center (LGBTC)",
                null, "Welcome to the Lesbian Gay Bisexual Transgender Center, a home away from home for sexual and gender minorities and their " +
                "allies at the University of Pennsylvania. Whether you are questioning your identity, in the process of coming out, proudly identify as LGBTQ+, or a ally, " +
                "the Center is your space. Not only do we offer peer mentorships, tons of space to study and socialize, and a calendar full of events, we're also a social " +
                "and political hub for the queer community on campus, hosting over 25 undergraduate and graduate student groups. We are one of the oldest and most active " +
                "LGBT centers in the country, and have been proudly serving the Penn queer community for 35 years. Join us at 3907 Spruce to study, relax with your friends, " +
                "and learn more about Penn's LGBTQ life.  We are all committed to serving the students, faculty, and staff of the University of Pennsylvania.",
                "sc", "Carriage House, 3907 Spruce Street",
                "https://www.vpul.upenn.edu/lgbtc/", 39.951930, -75.201590, "(215) 898-5044", false));

        //fitness
        resourceList.add(new Resource("The Office of Alcohol & Other Drug Program Initiatives (AOD)",
                "h", "The mission of the Office of Alcohol and Other Drug Program Initiatives " +
                "is to reduce harm related to alcohol and other drug use at the University of Pennsylvania.  " +
                "Key efforts focus on education, prevention and confidential, non-judgmental brief interventions for both individual Penn students and student groups.  " +
                "In accordance with this mission, the office oversees policies, environmental management efforts and educational programs that encourage a safe and healthy " +
                "campus environment for students.", "f",
                "3611 Locust Walk", "https://www.vpul.upenn.edu/alcohol/",
                39.954100, -75.211920, "(215) 573-3525", false));

        resourceList.add(new Resource("Listen to Workout Music",
                "h", "", "f",
                "",
                "", 1, 1, "", true));

        //sleep
        resourceList.add(new Resource("The Penn Program for Mindfulness, Stress Management, and More",
                "h", "The Penn Program for Mindfulness teaches you how to manage the stresses of life with powerful " +
                "mindfulness-based tools. Our programs will teach you how to actively manage the range of challenges that you face in " +
                "life while you learn to enhance well-being, improve relationships, and increase productivity.", "sl",
                "Various Philadelphia locations",
                "http://www.pennmedicine.org/stress/ ", 39.952049, -75.173492, "800-789-PENN(7366)", false));

        resourceList.add(new Resource("Listen to Music as You Fall Asleep",
                "h", "", "sl",
                "",
                "", 1, 1, "", true));
        //stress
        resourceList.add(new Resource("Penn Benjamins Peer Support",
                "h", "Penn Benjamins is a peer support organization run by students, for students. They offer confidential peer-to-peer talking and referral services to any member of the Penn undergraduate community.\n" +
                "·         *Penn Benjamins peer counselors are not licensed professional counselors. *Penn Benjamins is an independent student group. *No appointment necessary. Hours:\n" +
                "·         Sundays 8-11pm Harnwell First Floor Library\n" +
                "·         Mondays 8-11pm Harnwell First Floor Library\n" +
                "·         Tuesdays 8-11pm Harnwell First Floor Library\n" +
                "·         Wednesdays 8-11pm Chaplain's Office\n" +
                "·         Thursdays 8-11pm Chaplain's Office\n",
                "st", "Various Philadelphia locations",
                "pennbenjamins.org", 39.954100, -75.211920, "(901) 338-0828", false));

        resourceList.add(new Resource("Listen to Calming Music",
                "h", "", "st",
                "",
                "", 1, 1, "", true));

        User john = new User("John Doe", "username", "password");
        john.updateCommunity(0);
        //john.updateDiet(0);
       // john.updateFitness(8);
        john.updateMentalHealth(9);
        john.updateStress(4);
        john.updateSleep(0);
        userDB.add(john);
    }

    public List<Resource> getCategoryResource(String category) {
        List<Resource> categoryResources = null;
        for (Resource curr : resourceList) {
            if (curr.getCategory().equals(category)) {
                categoryResources.add(curr);
            }
        }
        return categoryResources;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public List<User> getUserDB() { return userDB; }

    public void addUser(User u) {
        userDB.add(u);
    }
}
