package com.booking.hackthon;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gogolook on 2017/3/11.
 */

public class Utils {

    private static final String[] NAMES = {"Zula Brenner", "Irena Crain", "Lovie Gossman", "Eddie Belliveau", "Alessandra Tourigny", "Hortense Tarlton", "Janie Mccowen", "Tai Bevill", "Audrie Fahie", "Jenifer Gobeil", "Vince Kleckner", "Solange Oneill", "Mariela Borg", "Roberta Pia", "Dexter Doom", "Tobie Hammond", "Roma Ivie", "Ellsworth Kappel", "Roman Bieker", "Annamaria Radosevich", "Lamont Scroggins", "Isis Doten", "Emilia Dehner", "Marcus Krumm", "Lavinia Peaden", "Tammara Seiter", "Luetta Ronan", "Mechelle Naples", "Kelle Cajigas", "Jerri Alarcon", "Kam Court", "Catrina Armes", "Giovanni Bibbs", "Dorris Holbert", "Gidget Mcclary", "Leon Tune", "Emmy Hector", "Deetta Schurman", "Kathaleen Mcalpin", "Cathrine Negri", "Eliana Caverly", "Sheree Kinsler", "Sonja Mccane", "Carmine Mazzotta", "Sherika Garnett", "Maira Mccloy", "Gonzalo Paavola", "Jama Mahmood", "Anjelica Brummer", "Cathey Cortina"};
    private static final String[] REVIEWS = {"I stayed at Ollies apartment for one night when I was visiting Melbourne. Unfortunately we didn´t have much time to hang out but Ollie is very friendly and helpful. :) Thank you for a great first couchsurfing experience."
            , "Ollie is a very humble and kind-hearted person. We've had great conversations about life. I showed him around Puerto Princesa and El Nido. I can see his different perspectives in life. We usually have a great dinner. I am pretty sure that he will be able to have a great success in life. I am looking forward in meeting you one day man. Thank you very much for everything!"
            , "I travelled with Ollie for one week through Vancouver Island and this fellow is super relaxed and friendly. He has great stories to share, he takes incredible pictures, he helped me improve my English and it's just overall fun to travel with him!"
            , "Ollie is a very kind and adventurous guy. I went with him to taste the \"Best Margarita pizza of the World\" at the restaurant 400 Gradi in Melbourne. I'll never forget his way to see life and treat people...see you the next time in Australia dear Ollie."
            , "Ollie is a good, down to earth guy. Unfortunately I wasn't able to host him but I travelled and snowboarded with him in Canada during his visit. Don't hesitate to host or travel with Ollie!"
            , "Marissa and I met in September 2008 in Banff and I just realized she is not on my friendslist yet! Shame on me! "
            , "We had a lot of fun and she is very helpful!"
            , "Cool laid back friendly guy, definitely recommend as a host. Thanks bro! Hope to have a fish with you before I leave :)"
            , "Marissa is a fucking cool girl, honestly. We had a great time with her. She's so cute and friendly! Hope you get to meet her!"
            , "I knew that Elyssa and her friend Ian would be tons of fun from the start, when they showed up in their clay painted Jetta! Elyssa is siiiiick, very easy to talk to, and made awesome pasta. I definitely hope to see her again."
            , "AWEEEESOME. Saw a band, climbed a mountain, slept Back-country, got drunk watching 'saved by the bell', had a comfy couch. Marissa is SIIIIIICK! lol! Always up for an adventure, always laughing (even when nearly falling to her death - no joke) and is a brilliant person to surf with. Welcome on my couch, in my tent or wherever I happen to be!! Thanks!!!"
            , "What can I say? Had an amazing time with Ian, whether we were dancing at a club (check out his moves!), climbing up a mountain, falling off of one, or watching Saved By the Bell. He's full of crazy stories and laughter and an all around fantastic guy. Come back to Banff!"
            , "Elphège is really nice. I came to Bordeaux for a Job interview. We´ve met in the city had a beer, a good dinner and a nice conversation. I recommend staying with him."
            , "Elphège is just a great host. I stayed with him in Bordeaux. He even showed me some parts of the city and he's a good chef as well. It was really great to stay with him, only recommendable :-)"
            , "Elphège is a really cool and a smart guy. I stayed at his place with a friend and he was helpful with showing us around, as well as taking us out to few bars on our first night. His apartment is in the center, so it's really easy to go around the town. "
            , "Thanks for everything man, hope to see you again!Elphege Very nice person , quit and respectful. "
            , "I enjoy from the company with him 😀 .. "
            , "I arrive only for 2 night's and we hang out our first night in very nice bar that he take us , and he show us the city center ..was great "
            , "Elphège was my first couchsurfing host ever and he made my stay in the beautiful city of Bordeaux even more memorable. He is a very considerate and calm person. I'm especially thankful for the bike tour he took me on, for the cozy conversations and dinner. I'm definitely coming back to Bordeaux."
            , "I really happy stay one night with Elphège. He and his flatmate are really nice and funny. We have a nice dinner, share our \"roommate\", took photos, watch video together. Elphège also show me around the beautiful city, make me fall in love with Ferrara!! Really wish we will meet again in somewhere in the world, and share the most beautiful place :)"
            , "Mohamed is a very nice host. He helped me a lot. We spent a good time, listening to great music, and talking about many differnet subjects. He shared with me some stories and photos from his travels, that were really amazing!(he is a great photographer)! "
            , "Also the place is close to the city center. "
            , "Mohamed is a very sympatic and interesting host. I just created my account on this site and he contacted me for the hosting, which helped me a lot. I really appreciated - Thanks again. "
            , "We discussed and I think we spent a good time. "
            , "On top of that, the flat is very well located in Bordeaux and close to tramway. "
            , "Chez Mohamed on se sent comme a la maison ! Tres accueillant ! Ouvert a toutes discution ... ca a ete un tres bon moment. A recommander en tant qu hote ;) Et a bientot j espere !"
            , "I stayed with Mohamed just for one night. We talked about our different experiences over a glass of mint tea while listening to folk music from many places in the world. He is fun, resourceful and open minded. "
            , "Mohamed can teach you many things about Moroccan culture and photography. "
            , "He lives in the city center in a nicely decorated apartment (he is found of arts and crats). "};
    private static final String[] PROFILES = {"Hey Hey, I'm so excited to visit Italy and make series of photographs about cities, places and maybe you. If you can accommodate me it will be so nice, nice nice. \nWe can share and maybe make me visit your favorite spots? \nSee ya", "Hola hola, \nI would love to surf in ur couch and discover your favorite spots. Tell me about your life and your travels, I would love to share stories with you. \nTell the great Roma that am coming with my backpack and my camera, tell the citie that I heard about it many times and Am coming now with my backpack and my camera... To get lost in it, to meet you and to have some great memories.", "Hey, Hola \nAm doing a Trip with my Backpack and my camera, I wanna get lost and discover Italy, meet you and have some great memories. Let me know If you have some couch I can surf on and I will share with you many stories. \nSee ya", "Hey Hey, I'm so excited to visit Italy and make photo series about cities, places and maybe you. If you can accommodate me it will be so nice, nice nice. \nWe can share and maybe make me visit your favorite spots? \nAm flying to Athene just after \nSee ya", "Heey Ya, For one day i will visit Athens, the city of gods. \n(I wrote an epic sentence but When I reread it, it sounded so creepy #StopCliché) \nIt will be nice if i can meet some cool locals so they can talk me about the culture and show me some spots. \nEfharistó polí", "Merhaba, from France to Greece via Italy, my final destination for this trip is Istanbul. I dreamed about for years and Finally Am coming. I would love to meet some locals to show me some cozy spots and to share moments and discussions. Let me know if u can let me surf on ur couch. \nTeşekkür", "\nI will be travelling solo for a few weeks and I will stay in Charleroi for a 24h stopover on my way from Morocco to Montenegro. Looking forward to meet locals there and hang out! If your couch is available during that time please contact me.\nHoping to hear from you soon,", "I will be travelling solo for a couple of weeks through the Balkans and I'm planning to stay one night in Podgorica to explore the town and its surroundings.\nI am hoping to meet locals who can share tips about Podgorica and the region. If your couch is available during that time please contact me.\nHoping to hear from you soon,", "I was rased and I believed that I needed things to be happy. I get a house, a car, a mobile phone, a boyfriend, a girlfriend, a cat, a washing machine... and I get rid of all of this. Now my life is contained in few cardboard boxes, a bike and a rice cooker.", "I constantly meet precious human being who I concider as brother and taking care of each other take most of my time and energy (such as mine students).", "I do regret that I can find less and less travelers here and more teens who care just about having a cheap week-end and good tips. If you don't concider like one of those sign your request with \"eat the road\" and I will know you pay enough attention at the profil of your potential host and are a true CS."};
    private static final String[] TAG = {"nightowl", "sleptOver", "shopaholic", "backpackerMaster", "outdoors", "vegetarian", "friendly", "gourmet", "photographers", "geek", "surfing", "scubaDiving", "chef"};
    private static final String[] EMOJIS = {"😃", "😂", "😉", "😔", "🤔", "😰", "😡", "😈", "👿", "😎"};
    private static final String[] PROFILE_URL = {"http://www.american.edu/uploads/profiles/large/chris_palmer_profile_11.jpg"
            , "https://expertbeacon.com/sites/default/files/advice_for_men_on_selecting_your_online_dating_profile_photo.jpg"
            , "http://devilsworkshop.org/files/2013/01/enlarged-facebook-profile-picture.jpg"
            , "http://bestprofilepix.com/wp-content/uploads/2014/08/beautiful-cute-baby-images-for-facebook.jpg"
            , "http://mypcwallpaper.com/wp-content/uploads/2011/05/facebook-girl-profile-picture-photos.jpg"
            , "http://whatsappdp.net/wp-content/uploads/2016/03/Best-whatsapp-profile-picture.jpg"
            , "https://competition.adesignaward.com/designer/402730e84c6706c1f1ef41c3dfea8a3be70fb187-big.jpg"
            , "http://www.worldsnowboardtour.com/wp-content/uploads/2012/04/mark-mcmorris-profile.jpg"
            , "https://s-media-cache-ak0.pinimg.com/236x/74/0d/3f/740d3f64768ebbc74370d2545d5fdff9.jpg"
            , "https://lh4.googleusercontent.com/-fHlz7kScna4/AAAAAAAAAAI/AAAAAAABS38/m2l9kOds1mE/photo.jpg"
            , "http://people.arcada.fi/~kantolaj/final/bilder/royface.jpg"
            , "http://www.kicnano.cornell.edu/wp-content/uploads/2010/12/Paszek-CBE-Cornell.jpg"
            , "http://evolutionofsport.com/wp-content/uploads/2014/11/Profile_Frank-150x150.jpg"
            , "http://makemyhome.online/testimonials_images/57836abfe5aa5.jpg"
            , "http://joseph-costello.com/wp-content/uploads/2013/01/profile.jpg"
            , "https://s-media-cache-ak0.pinimg.com/236x/ff/ae/7f/ffae7f7b96b3a2519c5ee75e3182e9c7.jpg"
            , "https://s3.amazonaws.com/37assets/svn/1065-IMG_2529.jpg"
            , "https://lh3.googleusercontent.com/-chfPV-CvlvI/AAAAAAAAAAI/AAAAAAAAAAA/ek1xYzXEIuE/photo.jpg"
            , "https://image.freepik.com/icone-gratis/nerd-profilo-avatar_318-68813.jpg"
            , "http://smboysgeneration.com/wp-content/uploads/2015/01/Boys-Generation-and-SMRookies-Profile-and-Facts-Doyoung-150x150.jpg"
            , "https://unsungbyul.files.wordpress.com/2011/06/vji9x.jpg"
            , "https://organicthemes.com/demo/profile/files/2012/12/profile_img.png"
            , "https://uploads.disquscdn.com/images/c2907527147414958d26eac47f61c5a8c4df5d0a20fef48cd743a2dfc12e8618.png"};

    public static void loadProfileImage(final Context context, final ImageView iv, String url) {
        Glide.with(context).load(url)
                .asBitmap()
                .placeholder(R.drawable.profile_empty)
                .centerCrop().into(new BitmapImageViewTarget(iv) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    public static void loadProfileImage(final Context context, final ImageView iv) {
        loadProfileImage(context, iv, "https://organicthemes.com/demo/profile/files/2012/12/profile_img.png");
    }

    public static ArrayList<Review> getReviewList(int count, int seed) {
        Random rand = new Random(seed);
        ArrayList<Review> arrayList = new ArrayList<>();
        while (arrayList.size() < count) {
            arrayList.add(new Review(
                    NAMES[rand.nextInt(NAMES.length)]
                    , REVIEWS[rand.nextInt(REVIEWS.length)]
                    , EMOJIS[rand.nextInt(EMOJIS.length)]
                    , PROFILE_URL[rand.nextInt(PROFILE_URL.length)]));
        }
        return arrayList;
    }

    public static String[] getTags(int seed) {
        Random rand = new Random(seed);
        int roll = rand.nextInt(14);

        if (roll > 12) {
            return new String[]{TAG[next(rand, TAG.length)]};
        } else if (roll < 10) {
            return new String[]{TAG[next(rand, TAG.length)], TAG[next(rand, TAG.length)]};
        } else {
            return new String[]{TAG[next(rand, TAG.length)], TAG[next(rand, TAG.length)], TAG[next(rand, TAG.length)], (rand.nextInt(5) +1)+ "+"};
        }
    }

    public static String getEmoji(int seed) {
        Random rand = new Random(seed);
        if (rand.nextInt(2) > 0) {
            return EMOJIS[next(rand, EMOJIS.length)] + " " + EMOJIS[next(rand, EMOJIS.length)];
        }
        return EMOJIS[next(rand, EMOJIS.length)] + " " + EMOJIS[next(rand, EMOJIS.length)] + " " + EMOJIS[next(rand, EMOJIS.length)];

    }

    static int last = -1;
    static int last_last = -1;

    public static int next(Random rand, int n) {
        int next = rand.nextInt(n);
        while (next == last || next == last_last)
            next = rand.nextInt(n);
        last_last = last;
        last = next;


        return next;
    }


    public static String getEmojiReview(int seed) {
        return "most common review: " + getEmoji(seed);
    }

    public static String getProfilePic(int seed) {
        return getRand(seed, PROFILE_URL);
    }


    public static String getSummary(int seed) {
        return getRand(seed, PROFILES);
    }

    public static String getName(int seed) {
        return getRand(seed, NAMES);
    }

    public static String getReview(int seed) {
        return getRand(seed, REVIEWS);
    }


    public static String getRand(int seed, String[] array) {
        Random rand = new Random(seed);
        return array[rand.nextInt(array.length)];
    }

    public static class Review {
        String name, comment, emoji, photo;

        public Review(String name, String comment, String emoji, String photo) {
            this.name = name;
            this.comment = comment;
            this.emoji = emoji;
            this.photo = photo;
        }
    }


}
