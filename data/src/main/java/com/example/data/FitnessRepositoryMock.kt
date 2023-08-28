package com.example.data

import com.example.domain.model.FitnessCalendarModel
import com.example.domain.model.FitnessHomeModel
import com.example.domain.model.date
import com.example.domain.repository.FitnessRepository

class FitnessRepositoryMock:FitnessRepository {


    override fun getHome(id: String): List<FitnessHomeModel> {
        return listOf(
            FitnessHomeModel(
            "1", R.drawable.img_home_recycler, "HILT", "High energy", 850,
                50, "Elevate your fitness with our High-Intensity Low-Impact Training (HILT) class. This session offers a challenging workout that focuses on boosting your cardiovascular endurance and strength while minimizing impact on your joints. Our knowledgeable trainers will guide you through a variety of exercises that can be tailored to different fitness levels.",
                "Join us for a unique fitness experience in our HILT class. Using a combination of interval training and functional movements, you'll engage multiple muscle groups and improve your overall fitness. Whether you're a beginner or an experienced athlete, you'll find the right level of challenge in this inclusive and effective workout."
            ),
            FitnessHomeModel(
                "2", R.drawable.img_home_recycler1, "Zumba", "Low energy", 450,
                30, "Get ready to dance your way to fitness with our Zumba class! Join us for an exciting and energetic workout that combines dance moves with cardio exercises. Our skilled instructors will lead you through a variety of rhythms and styles that will not only burn calories but also uplift your spirits. No dance experience required!",
                "Experience the joy of movement in our Zumba class. This dynamic fitness routine is designed to make you sweat and smile at the same time. With a mix of Latin and international music, you'll enjoy a full-body workout that feels more like a dance party than exercise. Suitable for all fitness levels."
            ),
            FitnessHomeModel(
                "3", R.drawable.img_home_recycler2, "Spinning", "Low energy", 450,
                50, "Join us for an intense Spinning session that will push your cardiovascular limits. Our energetic instructors will lead you through a dynamic indoor cycling workout designed to improve your endurance, burn calories, and boost your metabolism. Get ready to pedal your way to a healthier lifestyle!",
                "Ready to take on the challenge? Our Spinning class offers a high-energy, music-driven workout that simulates outdoor cycling without the need to worry about weather. Suitable for all fitness enthusiasts, this class promises an exhilarating experience that will leave you energized."
            ),
            FitnessHomeModel(
                "4", R.drawable.img_fitness_home_fragment, "Body Pump", "High energy",
                350, 25, "Get ready to feel strong and energized with the Body Pump workout! This intensive session involves exercises using dumbbells that target various muscle groups. Expect dynamic movements set to rhythmic music, focused on strengthening and toning your entire body. Guided by an experienced instructor, you'll conquer challenges and achieve new milestones. Body Pump is the perfect choice for those aiming to enhance strength, endurance, and overall body shape. Join the class to experience a surge of energy and confidence.",
                "Experience the dynamic fusion of music and resistance training with our Body Pump class. Sculpt and tone your body using a combination of free weights and high-energy movements. Our skilled instructors will guide you through a challenging yet invigorating workout that targets all major muscle groups. Whether you're a fitness enthusiast or new to strength training, Body Pump offers a fun and effective way to achieve your fitness goals."
            ),
            FitnessHomeModel(
                "5", R.drawable.img_book_classes_fragment, "Kettlebell", "High energy",
                350, 25, "Join us for an invigorating Kettlebell session that will challenge your strength and endurance. Our expert trainers will guide you through dynamic exercises aimed at building muscle and burning calories. Get ready to swing, press, and squat your way to a healthier you!",
                "Don't miss our exciting Kettlebell workout class. Using a combination of cardiovascular exercises and strength training, you'll experience a comprehensive fitness routine that targets various muscle groups. Suitable for all fitness levels."
            ),

        )
    }

    override fun getCalendar(id: String): List<FitnessCalendarModel> {
        return listOf(
            FitnessCalendarModel(
                "1", R.drawable.img_fitness_home_fragment, "Body Pump", 25,
                "24.10.2023", "Monday", "Low",
                "Get ready to feel strong and energized with the Body Pump workout! This intensive session involves exercises using dumbbells that target various muscle groups. Expect dynamic movements set to rhythmic music, focused on strengthening and toning your entire body. Guided by an experienced instructor, you'll conquer challenges and achieve new milestones. Body Pump is the perfect choice for those aiming to enhance strength, endurance, and overall body shape. Join the class to experience a surge of energy and confidence.",
                "Experience the dynamic fusion of music and resistance training with our Body Pump class. Sculpt and tone your body using a combination of free weights and high-energy movements. Our skilled instructors will guide you through a challenging yet invigorating workout that targets all major muscle groups. Whether you're a fitness enthusiast or new to strength training, Body Pump offers a fun and effective way to achieve your fitness goals."
            ),

            FitnessCalendarModel(
                "2", R.drawable.img_book_classes_fragment, "Kettlebell", 25,
                "25.08.2023", "Sunday", "High",
                "Join us for an invigorating Kettlebell session that will challenge your strength and endurance. Our expert trainers will guide you through dynamic exercises aimed at building muscle and burning calories. Get ready to swing, press, and squat your way to a healthier you!",
                "Don't miss our exciting Kettlebell workout class. Using a combination of cardiovascular exercises and strength training, you'll experience a comprehensive fitness routine that targets various muscle groups. Suitable for all fitness levels."
            ),

            FitnessCalendarModel(
                "3", R.drawable.img_home_recycler2, "Spinning", 50, "28.08.2023",
                "Tuesday", "High", "Join us for an intense Spinning session that will push your cardiovascular limits. Our energetic instructors will lead you through a dynamic indoor cycling workout designed to improve your endurance, burn calories, and boost your metabolism. Get ready to pedal your way to a healthier lifestyle!",
                "Ready to take on the challenge? Our Spinning class offers a high-energy, music-driven workout that simulates outdoor cycling without the need to worry about weather. Suitable for all fitness enthusiasts, this class promises an exhilarating experience that will leave you energized."
            ),
            FitnessCalendarModel(
                "4", R.drawable.img_home_recycler1, "Zumba", 30, "29.08.2023",
                "Friday", "High", "Get ready to dance your way to fitness with our Zumba class! Join us for an exciting and energetic workout that combines dance moves with cardio exercises. Our skilled instructors will lead you through a variety of rhythms and styles that will not only burn calories but also uplift your spirits. No dance experience required!",
                "Experience the joy of movement in our Zumba class. This dynamic fitness routine is designed to make you sweat and smile at the same time. With a mix of Latin and international music, you'll enjoy a full-body workout that feels more like a dance party than exercise. Suitable for all fitness levels."
            ),
            FitnessCalendarModel(
                "5", R.drawable.img_home_recycler, "HILT", 50, "31.08.2023",
                "Saturday", "Low", "Elevate your fitness with our High-Intensity Low-Impact Training (HILT) class. This session offers a challenging workout that focuses on boosting your cardiovascular endurance and strength while minimizing impact on your joints. Our knowledgeable trainers will guide you through a variety of exercises that can be tailored to different fitness levels.",
                "Join us for a unique fitness experience in our HILT class. Using a combination of interval training and functional movements, you'll engage multiple muscle groups and improve your overall fitness. Whether you're a beginner or an experienced athlete, you'll find the right level of challenge in this inclusive and effective workout."
            ),

            )
    }

    override fun getAvailableCalendarDates(): List<String> {
        return listOf("26.08.2023", "29.08.2023")
    }

}