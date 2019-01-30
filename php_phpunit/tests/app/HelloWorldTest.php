<?php declare(strict_types = 1);

namespace Tests;

use App\HelloWorld;
use PHPUnit\Framework\TestCase;

class HelloWorldTest extends TestCase
{
    private $helloWorld;
    
    public function setUp(): void
    {
        $this->helloWorld = new HelloWorld();
    }
    
    public function testEchoHelloWorld(): void
    {
        $this->expectOutputString('Hello World!' . PHP_EOL);
        
        $this->helloWorld->echoHelloWorld();
    }
}
