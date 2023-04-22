# ZEF-SERVER
- This repository has code of ZEF's Client.
- ZEF build REST API server using Springboot.
- Because of Security, we cannot provide environment file.
- THis is only demo. You can confirm our server with mobile application in May.

<br />

## 1. To Run Inference Of 
### 1. Environment
- If you want to test this model, you should install Docker.

<br />

_**HOW TO INSTALL DOCKER?**_
- Ubuntu
```bash
sudo apt update
sudo apt install docker.io
```

- Mac, Window
> Use Docker Desktop.
  [YOU CAN INSTALL HERE](https://www.docker.com/products/docker-desktop/)

<br />

### 2. Installation: HOW TO RUN?
1) Pull Docker Image
```bash
sudo docker pull sunnyineverywhere/fridge-api-springboot
```
2) Launch Docker Image In Conatainer
```bash
sudo docker run -d -p 8080:8080 sunnyineverywhere/fridge-api-springboot
```

## 2. Directory Tree
```
├── Dockerfile
├── HELP.md
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── scripts
│   └── deploy.sh
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── web
    │   │       └── fridge
    │   │           ├── SpeakingFridgeApplication.java
    │   │           ├── domain
    │   │           │   ├── family
    │   │           │   │   ├── FamilyRepository.java
    │   │           │   │   └── entity
    │   │           │   │       ├── Family.java
    │   │           │   │       └── Role.java
    │   │           │   ├── food
    │   │           │   │   ├── controller
    │   │           │   │   │   ├── FoodController.java
    │   │           │   │   │   ├── FridgeController.java
    │   │           │   │   │   └── dto
    │   │           │   │   │       ├── FoodAddRequestDTO.java
    │   │           │   │   │       ├── FoodEditRequestDTO.java
    │   │           │   │   │       ├── FoodResponseDTO.java
    │   │           │   │   │       ├── FoodStatusRequestDTO.java
    │   │           │   │   │       ├── FridgeMemberInviteDTO.java
    │   │           │   │   │       ├── FridgeMemberRemoveDTO.java
    │   │           │   │   │       ├── FridgeMemberWithdrawDTO.java
    │   │           │   │   │       ├── FridgeRemoveDTO.java
    │   │           │   │   │       └── FridgeResponseDTO.java
    │   │           │   │   ├── entity
    │   │           │   │   │   ├── Food.java
    │   │           │   │   │   ├── FoodStatus.java
    │   │           │   │   │   ├── Fridge.java
    │   │           │   │   │   └── FridgeType.java
    │   │           │   │   ├── repository
    │   │           │   │   │   ├── FoodRepository.java
    │   │           │   │   │   └── FridgeRepository.java
    │   │           │   │   └── service
    │   │           │   │       ├── FoodService.java
    │   │           │   │       └── FridgeService.java
    │   │           │   ├── hello
    │   │           │   │   └── HelloController.java
    │   │           │   ├── invitation
    │   │           │   │   ├── InvitationRepository.java
    │   │           │   │   ├── controller
    │   │           │   │   │   ├── InvitationController.java
    │   │           │   │   │   └── dto
    │   │           │   │   │       ├── InvitationAcceptDTO.java
    │   │           │   │   │       └── InvitationResponseDTO.java
    │   │           │   │   ├── entity
    │   │           │   │   │   ├── Invitation.java
    │   │           │   │   │   └── InvitationStatus.java
    │   │           │   │   └── service
    │   │           │   │       └── InvitationService.java
    │   │           │   ├── jwt
    │   │           │   │   ├── JwtAuthenticationFilter.java
    │   │           │   │   └── JwtService.java
    │   │           │   └── member
    │   │           │       ├── annotation
    │   │           │       │   ├── AuthMember.java
    │   │           │       │   └── AuthMemberArgumentResolver.java
    │   │           │       ├── controller
    │   │           │       │   ├── LogInController.java
    │   │           │       │   ├── MemberController.java
    │   │           │       │   └── dto
    │   │           │       │       ├── GoogleLogInRequestDTO.java
    │   │           │       │       ├── MemberNameModifyRequestDTO.java
    │   │           │       │       ├── MemberResponseDTO.java
    │   │           │       │       ├── NaverLogInRequestDTO.java
    │   │           │       │       └── OauthLogInResponseDTO.java
    │   │           │       ├── entity
    │   │           │       │   └── Member.java
    │   │           │       ├── repository
    │   │           │       │   └── MemberRepository.java
    │   │           │       └── service
    │   │           │           ├── LogInService.java
    │   │           │           └── MemberService.java
    │   │           └── global
    │   │               ├── config
    │   │               │   ├── AwsConfig.java
    │   │               │   ├── SecurityConfig.java
    │   │               │   ├── SwaggerConfig.java
    │   │               │   └── WebConfig.java
    │   │               ├── entity
    │   │               │   ├── BaseTimeEntity.java
    │   │               │   ├── ErrorResponse.java
    │   │               │   └── StatusEnum.java
    │   │               ├── enums
    │   │               │   ├── Status.java
    │   │               │   └── enumMappers
    │   │               │       ├── EnumMapper.java
    │   │               │       ├── EnumMapperFactory.java
    │   │               │       ├── EnumMapperType.java
    │   │               │       └── EnumMapperValue.java
    │   │               ├── exception
    │   │               │   └── GlobalExceptionController.java
    │   │               └── util
    │   │                   └── JsonUtil.java
    │   └── resources
    │       ├── application.yaml
    │       ├── static
    │       └── templates
    │           └── test.html
    └── test
        └── java
            └── web
                └── fridge
                    └── SpeakingFridgeApplicationTests.java
```
