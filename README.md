# EquestrianCenterServer
HorseController: GET("/horses"), GET("/horses/{id}"), GET("/horses/ill"), POST("/horses"), DELETE("/horses/{id}").

GroomController: GET("/grooms"), GET("/grooms/{id}"), POST("/grooms"), DELETE("/grooms/{id}").

VetController: GET("/vets"), GET("/vets/{id}"), POST("/vets"), DELETE("/vets/{id}").

TrainerController: GET("/trainers"), GET("/trainers/{id}"), POST("/trainers"), DELETE("/trainers/{id}").

ClientController: GET("/clients"), GET("/clients/{id}"), GET("/clients/{id}/possible-horses""), GET("/clients/{id}/possible-trainers"),  POST("/clients"), DELETE("/clients/{id}").

ClubAccountController: GET("/club"), POST("/club"), POST("/club/pay-salaries").

CareController: POST("/care/recover"), POST("/care/feed").
