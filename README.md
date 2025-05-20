# 🌐 breizhcamp-2025-jwtdemo-gateway

A lightweight Spring Boot project using **Spring Cloud Gateway** to act as a reverse proxy in front of a functional API (`breizhcamp-2025-demo-jwt-spring`) :
https://github.com/Code-with-us-fr/breizhcamp-2025-demo-jwt-spring

This demo illustrates how an API gateway can enhance security and observability with minimal configuration and code.

---

## 🎯 Goal

This gateway proxies requests to the protected backend API and demonstrates features that are **easy to add with Spring Cloud Gateway**, such as:

- Injecting custom request headers
- Adding response headers (e.g., request duration)
- Rejecting requests based on **User-Agent blacklist**
- Applying **rate limiting** (e.g., 1 request per 5 seconds)

---

## 🛣️ Architecture

Client ──▶ jwtdemo-gateway ──▶ demo-jwt-spring (API)
(filters) (/saloon, /token, etc.)

The gateway acts as a bouncer in front of your saloon 🍻 API :

- It checks the client’s hat (user-agent)
- Limits how often they knock at the door
- Keeps logs of everything
- Adds a stamp on the request and receipt

---

## ▶️ Features

| Feature              | Description                                               |
|----------------------|-----------------------------------------------------------|
| Header injection     | Adds a custom header to all requests to the backend       |
| Response header      | Measures and returns the request duration in the response |
| User-Agent blacklist | Blocks access from known bad agents (e.g. bots, scrapers) |
| Rate limiting        | Allows 1 request per 5 seconds (demo purpose)             |
| Centralized logging  | Logs all traffic for audit purposes                       |

---

## 📦 Dependencies

- `spring-cloud-starter-gateway`
- `spring-boot-starter-webflux`
- (Optionally) `spring-boot-starter-actuator` for metrics

---

## 🚀 Getting Started

### Prerequisites

- `demo-jwt-spring` must be running on `http://localhost:8081`

### Run the gateway

```bash
./mvnw spring-boot:run
```
