import React from "react";

function Body() {
  return (
    <div>
      <h2 className="section-title">Professional Summary</h2>
      <p>
        3 years of experience in design, development, and maintenance of web
        applications using Python, Java, Django, and Flask. Skilled in RESTful
        services, CI/CD, and AWS. Seeking a role in Python development for
        innovative projects.
      </p>

      <h2 className="section-title">Technical Skills</h2>
      <ul>
        <li>Languages: Python, GO, Django, Flask, Microservices</li>
        <li>Databases: SQL, Oracle SQL, Postgres, MongoDB</li>
        <li>Messaging Queues: Apache Airflow, RabbitMQ, Kafka</li>
        <li>Frameworks: TensorFlow, PyTorch, Scikit-learn</li>
        <li>Cloud: AWS, CloudFormation</li>
      </ul>

      <h2 className="section-title">Professional Experience</h2>

      <h3>Software Engineer, University of Louisiana at Lafayette</h3>
      <p>Aug 2022 - Dec 2023</p>
      <ul>
        <li>Developed RESTful APIs with Django and implemented token-based authentication.</li>
        <li>Utilized SonarQube, GitHub, Docker, and AWS for deployment and monitoring.</li>
        <li>Performed ETL tasks and presented data-driven reports using Matplotlib.</li>
      </ul>

      <h3>Software Engineer, FIS</h3>
      <p>Mar 2021 - Jul 2022</p>
      <ul>
        <li>Built Python backend components and utilized Flask scripts for testing.</li>
        <li>Worked with SQL Alchemy for database interactions and integrated CI/CD with Jenkins.</li>
        <li>Automated deployments with Ansible and managed environments with Docker.</li>
      </ul>

      <h2 className="section-title">Education</h2>
      <p>Master of Science in Computer Science, University of Louisiana at Lafayette | Aug 2022 – Dec 2023</p>
      <p>Bachelor of Technology in Computer Science, KL University | 2016 – 2020</p>
    </div>
  );
}

export default Body;
